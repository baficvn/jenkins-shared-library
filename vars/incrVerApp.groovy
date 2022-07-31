#!/usr/bin/env groovy
def call(BUILD_NUMBER){
    echo "Increment Version Application in pom.xml file ${BUILD_NUMBER}"
    String command = "mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    sh(command)
                    pom = readMavenPom file: 'pom.xml'
                    pom.version
                    def version = pom.version
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    //def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'
                    //echo "$IMAGE_NAME"
                    return "${IMAGE_NAME}"
}