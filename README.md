# Jenkins Shared Library

A centralized Jenkins Shared Library that provides reusable pipeline functions, utilities, and CI/CD best practices across multiple Jenkins projects.

## Overview

This repository contains common Jenkins pipeline code that can be shared across different projects to reduce duplication, improve maintainability, and enforce standard CI/CD processes.



### Directory Description

| Directory    | Purpose                                                       |
| ------------ | ------------------------------------------------------------- |
| `vars/`      | Global pipeline functions accessible directly in Jenkinsfiles |


---

## Configuring the Shared Library

1. Navigate to:

```text
Manage Jenkins
    └── System
          └── Global Trusted Pipeline Libraries
```

2. Add a new library:

| Field            | Value                                                  |
| ---------------- | ------------------------------------------------------ |
| Name             | shared-library                                         |
| Default Version  | main                                                   |
| Retrieval Method | Modern SCM                                             |
| SCM              | Git                                                    |
| Repository URL   | https://github.com/your-org/jenkins-shared-library.git |

3. Save the configuration.

---

## Using the Shared Library

Load the library in your Jenkinsfile:

```groovy
@Library('shared-library') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                buildApp()
            }
        }

        stage('Deploy') {
            steps {
                deployApp()
            }
        }
    }
}
```

---

## Example Global Function

### vars/buildApp.groovy

```groovy
def call() {
    echo "Building application..."
    sh 'mvn clean package'
}
```

Usage:

```groovy
buildApp()
```

---

## Example Utility Class

### src/com/company/BuildUtils.groovy

```groovy
package com.company

class BuildUtils implements Serializable {

    def steps

    BuildUtils(steps) {
        this.steps = steps
    }

    def buildMavenProject() {
        steps.sh 'mvn clean package'
    }
}
```

Usage:

```groovy
def utils = new com.company.BuildUtils(this)
utils.buildMavenProject()
```

---

## Best Practices

* Keep reusable logic inside the shared library.
* Use `vars/` for simple pipeline steps.
* Version control all changes.
* Test changes in a development Jenkins instance before production deployment.
* Maintain backward compatibility whenever possible.

---

## Versioning

Follow Semantic Versioning:

```text
MAJOR.MINOR.PATCH

Example:
v1.0.0
v1.1.0
v2.0.0
```

---

## Contributing

1. Create a feature branch.
2. Implement and test changes.
3. Submit a Pull Request.
4. Obtain approval before merging.

---


