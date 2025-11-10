package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
        properties([
            pipelineTriggers([githubPush()])
        ])

        stage('Checkout Main') {
            git url: "${repoUrl}", branch: "${branch}"
        }

        stage('Check Merge Conflicts') {
            sh "git fetch origin ${branch}"
            sh "git merge --no-commit origin/${branch} || true"

            def conflicts = sh(script: "git diff --name-only --diff-filter=U", returnStdout: true).trim()

            if (conflicts) {
                echo "Merge conflicts found in these files:"
                echo conflicts
                sh 'git merge --abort'
            } else {
                echo "No conflicts"
            }
        }
    }
}
