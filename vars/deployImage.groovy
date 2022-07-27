#!/usr/bin/env groovy
def call(String imageName){
    echo 'Deploy Docker Image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) 
    {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker image tag $imageName akakum/java-maven-app:latest"
        sh 'docker push akakum/java-maven-app:latest'
        
    }
}