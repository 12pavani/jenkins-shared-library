// Write a Jenkins pipeline that checks whether a pom.xml file exists in any subdirectory, not just one level deep. If the pom.xml file is found, generate the build; if it is not found, print "No pom.xml file found."

package org.pavani

void test() {
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

