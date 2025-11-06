package org.pavani

class RepoHelper implements Serializable {
    def steps

    RepoHelper(steps) {
        this.steps = steps
    }

    def cleanWorkspace() {
        steps.echo "Cleaning workspace..."
        steps.sh "rm -rf *"
    }

    def cloneRepo(repoName, branch='main', url) {
        if (steps.fileExists(repoName)) {
            steps.echo "${repoName} already exists, deleting it..."
            steps.sh "rm -rf ${repoName}"
        } else {
            steps.echo "${repoName} not found, cloning fresh..."
        }
        steps.echo "Cloning ${repoName} from ${url} (branch: ${branch})..."
        steps.sh "git clone -b ${branch} ${url} ${repoName}"
    }
}
