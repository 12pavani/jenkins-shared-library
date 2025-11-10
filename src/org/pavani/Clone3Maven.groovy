// Clone three Maven repositories and generate their builds in a single pipeline execution. After all builds are successful, replay the successful build again and ensure it runs successfully.

package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Cleaning workspace..."
        deleteDir()

        stage("Building Mavenrepo-1") {
            def repoName = 'Mavenrepo-1'
            def repoUrl = 'https://github.com/12pavani/Leave_Management_Backend.git'
            def branch = 'main'

            echo "Cloning ${repoUrl} ..."
            sh "git clone -b ${branch} ${repoUrl} ${repoName}"

            def pomFiles = sh(script: "find ${repoName} -name 'pom.xml'", returnStdout: true).trim()
            if (pomFiles) {
                echo "Found pom.xml files:\n${pomFiles}"
                withMaven(maven: 'Maven 3.9.9') {
                    sh "mvn -f ${repoName}/pom.xml -B -DskipTests clean install"
                }
                echo "Build for ${repoName} completed successfully!"
            } else {
                echo "No pom.xml file found in ${repoName}."
            }
        }

        stage("Building Mavenrepo-2") {
            def repoName = 'Mavenrepo-2'
            def repoUrl = 'https://github.com/sharmar0790/spring-boot-multi-module-maven.git'
            def branch = 'master'

            echo "Cloning ${repoUrl} ..."
            sh "git clone -b ${branch} ${repoUrl} ${repoName}"

            def pomFiles = sh(script: "find ${repoName} -name 'pom.xml'", returnStdout: true).trim()
            if (pomFiles) {
                echo "Found pom.xml files:\n${pomFiles}"
                withMaven(maven: 'Maven 3.9.9') {
                    sh "mvn -f ${repoName}/pom.xml -B -DskipTests clean install"
                }
                echo "Build for ${repoName} completed successfully!"
            } else {
                echo "No pom.xml file found in ${repoName}."
            }
        }

        stage("Building Mavenrepo-3") {
            def repoName = 'Mavenrepo-3'
            def repoUrl = 'https://github.com/jenkins-docs/simple-java-maven-app.git'
            def branch = 'master'

            echo "Cloning ${repoUrl} ..."
            sh "git clone -b ${branch} ${repoUrl} ${repoName}"

            def pomFiles = sh(script: "find ${repoName} -name 'pom.xml'", returnStdout: true).trim()
            if (pomFiles) {
                echo "Found pom.xml files:\n${pomFiles}"
                withMaven(maven: 'Maven 3.9.9') {
                    sh "mvn -f ${repoName}/pom.xml -B -DskipTests clean install"
                }
                echo "Build for ${repoName} completed successfully!"
            } else {
                echo "No pom.xml file found in ${repoName}."
            }
        }

        echo "All builds completed. Cleaning workspace..."
        deleteDir()
    }
}