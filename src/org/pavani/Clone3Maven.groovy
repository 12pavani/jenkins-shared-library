// Clone three Maven repositories and generate their builds in a single pipeline execution. After all builds are successful, replay the successful build again and ensure it runs successfully.

package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Cleaning workspace..."
        sh "rm -rf *"

        stage("Building ${repoName}") {
            echo "Cloning ${repoUrl} ..."
            sh "git clone -b ${branch} ${repoUrl} ${repoName}"
            def pomFiles1 = sh(script: "find ${repoName} -name 'pom.xml'", returnStdout: true).trim()

            if (pomFiles1) {
                echo "Found pom.xml files:\n${pomFiles1}"
                withMaven(maven: 'Maven 3.9.9') {
                    sh "mvn -f ${repoName}/pom.xml -B -DskipTests clean install"
                }
                echo "Build for ${repoName} completed successfully!"
            } else {
                echo "No pom.xml file found in ${repoName}."
            }
        }

    }
}