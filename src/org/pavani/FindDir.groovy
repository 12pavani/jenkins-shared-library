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
