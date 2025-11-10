// return [
    //     buildHelper: { -> new org.pavani.BuildHelper(this) },
    //     repoHelper : { -> new org.pavani.RepoHelper(this) },
    //     searchPomHelper : { -> new org.pavani.SearchPomHelper(this) }
    // ]

//================================================================================

def call() {

    if(JOB_NAME.contains("demo-global-shared-lib")) {
        def buildHelper = new org.pavani.BuildHelper()
        buildHelper.test()
    }
    else if(JOB_NAME.contains("demo-clone-two-repo")) {
        def repoHelper = new org.pavani.RepoHelper()
        repoHelper.test()
    } 
    else if(JOB_NAME.contains("demo-find-pom-xml")) {
        def searchPomHelper = new org.pavani.SearchPomHelper()
        searchPomHelper.test()
    }
    else if(JOB_NAME.contains("demo-clone-3-maven")) {
        def clone3Maven = new org.pavani.Clone3Maven()
        clone3Maven.test()
    }
    else if(JOB_NAME.contains("demo-find-recreate-dir")) {
        def findDir = new org.pavani.FindDir()
        findDir.test()
    }
    else if(JOB_NAME.contains("demo-webhook-github")) {
        def webhookHelper = new org.pavani.WebhookHelper()
        webhookHelper.test()
    }
}

