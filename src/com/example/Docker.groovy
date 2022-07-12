#!/usr/bin/env groovy
package com.example
class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }
    def BuildDockerImage(String imageName){ // imageName is akakum/java-maven-app:lst
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName . "  //akakum/java-maven-app:lst . "
        script.sh 'docker image ls'
    }
   /* 
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) 
    {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push akakum/java-maven-app:lst'
    }
    */
}