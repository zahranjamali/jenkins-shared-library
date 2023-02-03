#!/usr/bin/env groovy

def call () {
    echo "building the application"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t zahranjamali/my-repo:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push zahranjamali/my-repo:jma-1.0'
    }
}
