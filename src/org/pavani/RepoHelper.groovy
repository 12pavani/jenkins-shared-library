// clone 2 same repos, and no error in replaying

package org.pavani

void test() {
    node {
    echo "Starting build process for GitDemo-1..."

    echo "Cleaning workspace..."
    sh "rm -rf GitDemo-1"

    echo "Cloning the repository..."
    sh "git clone -b master https://github.com/jenkins-docs/simple-java-maven-app.git GitDemo-1"

    echo "Building the project using Maven..."
    withMaven(maven: 'Maven 3.9.9') {
        sh "mvn -f GitDemo-1/pom.xml -B -DskipTests clean package"
    }

    echo "Build for GitDemo-1 completed successfully!"

    echo "Starting build process for GitDemo-2..."

    echo "Cleaning workspace..."
    sh "rm -rf GitDemo-2"

    echo "Cloning the repository..."
    sh "git clone -b master https://github.com/jenkins-docs/simple-java-maven-app.git GitDemo-2"

    echo "Building the project using Maven..."
    withMaven(maven: 'Maven 3.9.9') {
        sh "mvn -f GitDemo-2/pom.xml -B -DskipTests clean package"
    }

    echo "Build for GitDemo-2 completed successfully!"

    echo "Cleaning workspace..."
    sh "rm -rf GitDemo-1 GitDemo-2"
}

}
