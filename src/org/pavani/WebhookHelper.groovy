package org.pavani

void test(String repoName, String repoUrl, String branch = 'main') {
    node {
    properties([
        pipelineTriggers([githubPush()])
    ])

    stage('Checkout Main') {
        git url: ${repoUrl}, branch: ${branch}
    }

    stage('Check Merge Conflicts') {
        sh 'git fetch origin pavani'

        sh 'git merge --no-commit origin/pavani || true'

        def conflicts = sh(script: "git diff --name-only --diff-filter=U", returnStdout: true).trim()

        if (conflicts) {
            echo "Merge conflicts found in these files:"
            echo conflicts
        } else {
            echo "No conflicts"
        }
    }
}

}