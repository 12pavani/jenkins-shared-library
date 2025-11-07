// package org.package

// class Clone3Maven implements Serializable {
//     def mvnHome = tool name: 'Maven 3.9.9', type: 'maven'
//     def steps

//     Clone3Maven(steps) {
//         this.steps = steps
//     }

//     def cleanWorkspace() {
//         steps.echo "Cleaning workspace"
//         steps.sh "rm -rf *"
//     }

//     def cloneThreeRepo(repoNumber, repoName) {
//         steps.echo "Cloning Maven project ${repoNumber}"
//         steps.sh "git clone -b main https://github.com/12pavani/${repoName}.git"
        
//         steps.echo "Building Maven project ${repoNumber}"
//         steps.sh """
//             cd ${repoName}
//             $mvnHome/bin/mvn -B -DskipTests clean package
//         """
//     }
// }

echo "Im in Clone3Maven"