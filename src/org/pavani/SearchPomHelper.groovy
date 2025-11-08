package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    echo "11"

    node {
        echo "22"
        def mvnHome = tool name: 'maven', type: 'maven'

        stage('Clone & Build') {
            echo "33"

            sh "rm -rf repo"
            sh "mkdir repo"

            dir('repo') {
                echo "44"
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

