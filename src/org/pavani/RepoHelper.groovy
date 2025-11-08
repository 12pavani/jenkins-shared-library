package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Starting build process for ${repoName}..."

        echo "Cleaning workspace..."
        sh "rm -rf *"

        echo "Cloning the repository..."
        git branch: branch, url: repoUrl

        echo "Building the project using Maven..."
        withMaven(maven: 'Maven 3.9.9') {
            sh "mvn -B -DskipTests clean package"
        }

        echo "Build for ${repoName} completed successfully!"
    }
}

