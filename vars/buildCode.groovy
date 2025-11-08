// return [
    //     buildHelper: { -> new org.pavani.BuildHelper(this) },
    //     repoHelper : { -> new org.pavani.RepoHelper(this) },
    //     searchPomHelper : { -> new org.pavani.SearchPomHelper(this) }
    // ]

//================================================================================

def call(String repoName, String repoUrl, String branch = 'main') {

    if(JOB_NAME.contains("demo-global-shared-lib")) {
        def buildHelper = new org.pavani.BuildHelper()
        buildHelper.test(repoName, repoUrl, branch)
    }
    else if(JOB_NAME.contains("demo-clone-two-repo")) {
        def repoHelper = new org.pavani.RepoHelper()
        repoHelper.test(repoName, repoUrl, branch)
    } 
    else if(JOB_NAME.contains("demo-find-pom-xml")) {
        def searchPomHelper = new org.pavani.SearchPomHelper()
        searchPomHelper.test()
    }
}

