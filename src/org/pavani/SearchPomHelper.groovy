package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        echo "Starting build process for ${repoName}..."

        sh "rm -rf *"

        sh "git clone -b ${branch} ${repoUrl} ${repoName}"

        def pomFiles = sh(
            script: "find ${repoName} -type f -name 'pom.xml'",
            returnStdout: true
        ).trim().split('\n')

        if (pomFiles && pomFiles[0].trim() != "") {
            echo "Found ${pomFiles.size()} pom.xml file(s). Starting build..."

            withMaven(maven: 'Maven 3.9.9') {
                for (pom in pomFiles) {
                    echo "Building: ${pom}"
                    sh "mvn -f '${pom}' -B -DskipTests clean package"
                }
            }

            echo "All Maven builds completed successfully!"
        } else {
            echo "No pom.xml files found in the repository."
        }
    }
}
