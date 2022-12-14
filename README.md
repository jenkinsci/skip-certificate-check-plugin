# Skip certificate check plugin

This is a plugin that makes JVM bypass all HTTPS certificate checks.
Convenient if you deal with self-signed certificates and so on.
Use with caution.

## Usage

This plugin doesn't require any configuration.
It activates itself when Jenkins starts.

## Changelog

### Version 1.1 (Dec 14, 2022)

-   Require Jenkins 2.346.3 or newer.
    Resolves implied dependency on WMI Windows Agents plugin

### Version 1.0 (Sep 7th 2011)

-   initial version
