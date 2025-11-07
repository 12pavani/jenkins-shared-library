// package org.pavani

// class BuildHelper implements Serializable {
//     def steps

//     BuildHelper(steps) {
//         this.steps = steps
//     }

//     def buildProject() {
//         steps.echo "Starting build process..."
//         steps.echo "Cleaning workspace..."
//         steps.sh "rm -rf *"

//         steps.echo "Cloning the repository..."
//         steps.git branch: 'master', url: 'https://github.com/jenkins-docs/simple-java-maven-app.git'

//         steps.echo "Building the project using Maven..."
//         steps.withMaven(maven: 'Maven 3.9.9') {
//             steps.sh "mvn -B -DskipTests clean package"
//         }

//         steps.echo "Build completed successfully!"
//     }
// }
