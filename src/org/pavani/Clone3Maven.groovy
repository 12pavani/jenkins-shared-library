// Clone three Maven repositories and generate their builds in a single pipeline execution. After all builds are successful, replay the successful build again and ensure it runs successfully.

package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
    echo "Cleaning workspace..."
    deleteDir()

    stage("Building Mavenrepo-1") {
        echo "Cloning https://github.com/12pavani/Leave_Management_Backend.git ..."
        sh "git clone -b main https://github.com/12pavani/Leave_Management_Backend.git Mavenrepo-1"

        pomFiles = sh(script: "find Mavenrepo-1 -name 'pom.xml'", returnStdout: true).trim()
        if (pomFiles) {
            echo "Found pom.xml files:\n${pomFiles}"
            withMaven(maven: 'Maven 3.9.9') {
                sh "mvn -f Mavenrepo-1/pom.xml -B -DskipTests clean install"
            }
            echo "Build for Mavenrepo-1 completed successfully!"
        } else {
            echo "No pom.xml file found in Mavenrepo-1."
        }
    }

    stage("Building Mavenrepo-2") {
        echo "Cloning https://github.com/sharmar0790/spring-boot-multi-module-maven.git ..."
        sh "git clone -b master https://github.com/sharmar0790/spring-boot-multi-module-maven.git Mavenrepo-2"

        pomFiles = sh(script: "find Mavenrepo-2 -name 'pom.xml'", returnStdout: true).trim()
        if (pomFiles) {
            echo "Found pom.xml files:\n${pomFiles}"
            withMaven(maven: 'Maven 3.9.9') {
                sh "mvn -f Mavenrepo-2/pom.xml -B -DskipTests clean install"
            }
            echo "Build for Mavenrepo-2 completed successfully!"
        } else {
            echo "No pom.xml file found in Mavenrepo-2."
        }
    }

    stage("Building Mavenrepo-3") {
        echo "Cloning https://github.com/jenkins-docs/simple-java-maven-app.git ..."
        sh "git clone -b master https://github.com/jenkins-docs/simple-java-maven-app.git Mavenrepo-3"

        pomFiles = sh(script: "find Mavenrepo-3 -name 'pom.xml'", returnStdout: true).trim()
        if (pomFiles) {
            echo "Found pom.xml files:\n${pomFiles}"
            withMaven(maven: 'Maven 3.9.9') {
                sh "mvn -f Mavenrepo-3/pom.xml -B -DskipTests clean install"
            }
            echo "Build for Mavenrepo-3 completed successfully!"
        } else {
            echo "No pom.xml file found in Mavenrepo-3."
        }
    }

    echo "All builds completed. Cleaning workspace..."
    deleteDir()
}
}