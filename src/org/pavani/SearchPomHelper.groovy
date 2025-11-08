package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Starting build process for ${repoName}..."

        echo "Cleaning workspace..."
        sh "rm -rf *"

        echo "Cloning the repository..."
        sh "git clone -b ${branch} ${repoUrl} ${repoName}"

        echo "Searching for pom.xml file..."
        def pomFile = sh(script: "find . -name 'pom.xml' | head -n 1", returnStdout: true).trim()

        if (pomFile) {
            echo "pom.xml found at: ${pomFile}"
            echo "Starting Maven build..."
            withMaven(maven: 'Maven 3.9.9') {
                sh "mvn -f ${pomFile} -B -DskipTests clean package"
            }
            echo "Build for ${repoName} completed successfully!"
        } else {
            echo "No pom.xml file found in ${repoName}."
        }
    }
}
