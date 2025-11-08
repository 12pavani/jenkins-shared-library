package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        def mvnHome = tool name: 'Maven 3.9.9', type: 'maven'

        stage('Clone & Build') {

            sh "rm -rf *"
            sh "mkdir ${repoName}"

            dir('${repoName}') {
                git branch: branch, url: repoUrl

                def pomExists = sh(script: "find . -name 'pom.xml' | wc -l", returnStdout: true).trim()

                if (pomExists.toInteger() > 0) {
                    echo "Found ${pomExists} pom.xml file(s). Starting Maven build..."
                    sh "${mvnHome}/bin/mvn -B -DskipTests clean install"
                } else {
                    echo "No pom.xml file found"
                }
            }
        }
    }
}

