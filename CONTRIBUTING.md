# Contributing to the skip-certificate-check-plugin


Plugin source code is hosted on [GitHub](https://github.com/jenkinsci/skip-certificate-check-plugin).
New feature proposals and bug fix proposals should be submitted as
[GitHub pull requests](https://help.github.com/articles/creating-a-pull-request).
Your pull request will be evaluated by the [Jenkins job](https://ci.jenkins.io/job/Plugins/job/skip-certificate-check-plugin/).

Before submitting your change, please assure that you've added tests which verify your change.

## Run Locally

Prerequisites: Java, Maven

* Ensure Java 11 or 17 is available.

```bash
  $ java -version
```

* Ensure Maven is included in the PATH environment variable.

```bash
  export PATH=$PATH:/path/to/apache-maven-3.8.6/bin
```
* To run a plugin locally, the command is:

```bash
  mvn hpi:run
```

* That starts a Jenkins controller with the minimum Jenkins version supported by the plugin and loads the plugin and its dependencies into that controller. Jenkins will be running on port 8080 and can be reached with the URL http://localhost:8080/jenkins/

  If a plugin maintainer wants to use a different Jenkins version, they run the command:

```bash
  mvn -Djenkins.version=2.375.1 hpi:run
```

* If a plugin maintainer wants to use a different HTTP port, (as in http://localhost:9090/jenkins) they run the command:

```bash
  mvn -Dport=9090 hpi:run
```

* If a plugin maintainer wants to allow other computers to access that Jenkins controller while it is running, they run the command:

```bash
  mvn -Dhost=0.0.0.0 hpi:run
```

## Code Coverage

[JaCoCo code coverage](https://www.jacoco.org/jacoco/) reporting is available as a maven target and can be displayed by the [Jenkins warnings next generation plugin](https://plugins.jenkins.io/warnings-ng/).
Please try to improve code coverage with tests when you submit.
* `mvn -P enable-jacoco clean install jacoco:report` to report code coverage with JaCoCo.

Please don't introduce new spotbugs output.
* `mvn spotbugs:check` to analyze project using [Spotbugs](https://spotbugs.github.io)
* `mvn spotbugs:gui` to review report using GUI

## Maintaining automated tests

Automated tests are run as part of the `verify` phase.
Run automated tests with multiple Java virtual machines in a development with the command:

```
$ mvn clean -DforkCount=1C verify
```

## Report an Issue

Use the ["Report an issue" page](https://www.jenkins.io/participate/report-issue/redirect/#15923) to submit bug reports.

## Security Issues

Follow the [Jenkins project vulnerability reporting instructions](https://jenkins.io/security/reporting/) to report vulnerabilities.