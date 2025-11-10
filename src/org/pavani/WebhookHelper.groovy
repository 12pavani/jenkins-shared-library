// Create webhook in git hub repo & when we do PR event if any conflicts get the file name if not conflict just print no conflicts

package org.pavani

void test() {
    node {
        // properties([
        //     pipelineTriggers([githubPush()])
        // ])

        // stage('Checkout Main') {
        //     git url: "${repoUrl}", branch: "${branch}"
        // }

        // stage('Check Merge Conflicts') {
        //     sh "git fetch origin ${branch}"
        //     sh "git merge --no-commit origin/${branch} || true"

        //     def conflicts = sh(script: "git diff --name-only --diff-filter=U", returnStdout: true).trim()

        //     if (conflicts) {
        //         echo "Merge conflicts found in these files:"
        //         echo conflicts
        //         sh 'git merge --abort'
        //     } else {
        //         echo "No conflicts"
        //     }
        // }
    }
}
