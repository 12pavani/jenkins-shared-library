package org.pavani

class SearchPomHelper implements Serializable {
    def steps

    SearchPomHelper(steps) {
        this.steps = steps
    }

    def cleanWorkspace() {
        steps.echo "Cleaning workspace..."
        steps.sh 'rm -rf'
    }

    def cloneRepo() {
        steps.echo "Cloning the repository..."
        steps.git branch: 'master', url: 'https://github.com/sharmar0790/spring-boot-multi-module-maven.git'
    }

    def checkPomXml() {
        def pomFile = sh(script: "find . -name 'pom.xml'", returnStdout: true).trim()

        if (pomFile) {
            echo "Pom.xml found at: ${pomFile}"
            echo "Starting Maven build..."

            withMaven(maven: 'Maven 3.9.9') {
                sh "mvn -B -DskipTests clean package"
            }
        } else {
            echo "No pom.xml file found in any subdirectory."
        }
    }
}