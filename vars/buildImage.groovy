#!/usr/bin/env groovy
def call() {
    echo "building the docker image..."
     sh "docker build -t akakum/java-maven-app:lst  . "
     sh 'docker image ls'
    }
 