#!/usr/bin/env groovy
def call(String BUILD_NUMBER){
    echo 'Increment Version Application in pom.xml file'
    String command = "mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    sh(command)
                    //def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'
                    pom = readMavenPom file: 'pom.xml'
                    pom.version
                    def version = pom.version
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    //echo "$IMAGE_NAME"
}