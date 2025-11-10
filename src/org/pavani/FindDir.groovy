//  If folder A has a subfolder B, and B contains two subfolders named C and D, check if B has any subfolders. If subfolders are present, clean and recreate them immediately. If no subfolders exist, then create them.

package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        stage('Check and Create Folders') {
            echo "Checking folder structure..."

            sh '''
                mkdir -p A/B
                if [ "$(find A/B -mindepth 1 -maxdepth 1 -type d)" ]; then
                    echo "Subfolders found inside A/B. Cleaning and recreating..."
                    rm -rf A/B/*
                    mkdir -p A/B/C A/B/D
                else
                    echo "No subfolders found. Creating C and D..."
                    mkdir -p A/B/C A/B/D
                fi
            '''

            echo "Folder setup completed!"
        }
    }
}
