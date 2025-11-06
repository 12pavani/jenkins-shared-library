def call() {
    return [
        buildHelper: { -> new org.pavani.BuildHelper(this) },
        repoHelper : { -> new org.pavani.RepoHelper(this) }
    ]
}
