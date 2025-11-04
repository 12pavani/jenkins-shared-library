def call() {
    echo "Starting build process..."

    echo "Cleaning workspace..."
    sh "rm -rf *"

    echo "Cloning the repository..."
    git branch: 'master', url: 'https://github.com/jenkins-docs/simple-java-maven-app.git'

    echo "Building the project using Maven..."
    withMaven(maven: 'Maven 3.9.9') {
        sh "mvn -B -DskipTests clean package"
    }

    echo "Build completed successfully!"
}
