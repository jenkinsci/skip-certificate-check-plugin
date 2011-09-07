package org.jenkinsci.plugins.skipcert;

import hudson.Extension;
import hudson.model.listeners.ItemListener;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension
public class ItemListenerImpl extends ItemListener {
    @Override
    public void onLoaded() {
        LOGGER.info("Bypassing certificate check");

        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[]{new NoCheckTrustManager()}, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
            // bypass host name check, too.
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.WARNING, "Failed to bypass certificate check", e);
        } catch (KeyManagementException e) {
            LOGGER.log(Level.WARNING, "Failed to bypass certificate check", e);
        }

    }

    private static class NoCheckTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static final Logger LOGGER = Logger.getLogger(ItemListenerImpl.class.getName());
}
