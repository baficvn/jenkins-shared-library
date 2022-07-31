#!/usr/bin/env groovy
def call(){
    echo 'Increment Version Application in pom.xml file'
    String command = "mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    sh(command)
                    //def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'
                    //echo "$IMAGE_NAME"
}