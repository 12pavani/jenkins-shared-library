package org.pavani

void test() {
    node {
    echo "Starting build process for clone-1..."

    echo "Cleaning workspace..."
    sh "rm -rf clone-1"

    echo "Cloning the repository..."
    sh "git clone -b master https://github.com/jenkins-docs/simple-java-maven-app.git clone-1"

    echo "Building the project using Maven..."
    withMaven(maven: 'Maven 3.9.9') {
        sh "mvn -f clone-1/pom.xml -B -DskipTests clean package"
    }

    echo "Build for clone-1 completed successfully!"

    echo "Cleaning workspace..."
    sh "rm -rf clone-1"
}
}
