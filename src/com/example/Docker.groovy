#!/usr/bin/env groovy
package com.example
class Docker implements Serializable  {
    def script
    Docker(script){
        this.script = script
    }
    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh "docker build -t $imageName ."
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh "docker push $script.imageName"
        }
    }
}
