// return [
    //     buildHelper: { -> new org.pavani.BuildHelper(this) },
    //     repoHelper : { -> new org.pavani.RepoHelper(this) },
    //     searchPomHelper : { -> new org.pavani.SearchPomHelper(this) }
    // ]

// def call(Map config = [:]) {

//     if(JOB_NAME.contains("demo-global-shared-lib")) {
//         def buildHelper = new org.pavani.BuildHelper(this)
//         buildHelper.buildProject()
//     } else if(JOB_NAME.contains("demo-clone-two-repo")) {
//         def repoHelper = new org.pavani.RepoHelper(this)
//         repoHelper.cleanWorkspace()
//         def repos = config.repos ?: []
//         for(repo in repos) {
//             repoHelper.cloneRepo(repo.repoName, repo.branch, repo.url)
//         }
//     } else if(JOB_NAME.contains("demo-find-pom-xml")) {
//         def searchPomHelper = new org.pavani.SearchPomHelper(this)
//         searchPomHelper.cleanWorkspace()
//         searchPomHelper.cloneRepo()
//         searchPomHelper.checkPomXml()
//     } else if(JOB_NAME.contains("demo-clone-3-maven")) {
//         def clone3Repo = new org.pavani.Clone3Maven(this)
//         clone3Repo.cleanWorkspace()
//         def repos = config.repos ?: []
//         for(repo in repos) {
//             clone3Repo.cloneThreeRepo(repo.repoNumber, repo.repoName)
//         }
//     }
// }

def call(Map config = [:]) {
    if (JOB_NAME.contains("demo-global-shared-lib")) {
        return new org.pavani.BuildHelper(this)
    } else if (JOB_NAME.contains("demo-clone-two-repo")) {
        return new org.pavani.RepoHelper(this)
    } else if (JOB_NAME.contains("demo-find-pom-xml")) {
        return new org.pavani.SearchPomHelper(this)
    } else if (JOB_NAME.contains("demo-clone-3-maven")) {
        return new org.pavani.Clone3Maven(this)
    }
    return null
}
