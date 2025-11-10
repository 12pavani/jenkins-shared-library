package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Starting build process for ${repoName}..."
        
        echo "Cloning the repository..."
        git branch: branch, url: repoUrl
        
        echo "Building the project using Maven..."
        withMaven(maven: 'Maven 3.9.9') {
            sh "mvn -B -DskipTests clean package"
        }

        echo "Removing cloned repository..."
        sh "rm -rf ${repoName}"  

        echo "Build for ${repoName} completed successfully!"
    }
}
