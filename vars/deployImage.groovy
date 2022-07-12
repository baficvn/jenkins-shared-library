#!/usr/bin/env groovy
def call(){
    echo 'Deploy Docker Image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) 
    {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push akakum/java-maven-app:lst'
    }
}