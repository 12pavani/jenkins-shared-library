// Write a Jenkins pipeline that checks whether a pom.xml file exists in any subdirectory, not just one level deep. If the pom.xml file is found, generate the build; if it is not found, print "No pom.xml file found."

package org.pavani

void test() {
    node {
    def mvnHome = tool name: 'Maven 3.9.9', type: 'maven'

    echo "Cleaning workspace..."
    sh "rm -rf repo-1"

    echo "Cloning repository..."
    sh "git clone -b master https://github.com/sharmar0790/spring-boot-multi-module-maven.git repo-1"

    echo "Checking for pom.xml files..."
    def pomExists = sh(script: "find repo-1 -name 'pom.xml' | wc -l", returnStdout: true).trim()

    if (pomExists.toInteger() > 0) {
        echo "Found ${pomExists} pom.xml file(s). Starting Maven build..."
        sh "${mvnHome}/bin/mvn -f repo-1/pom.xml -B -DskipTests clean install"
    } else {
        echo "No pom.xml file found in repo-1"
    }

    echo "Build completed. Cleaning workspace..."
    sh "rm -rf repo-1"
}
}

