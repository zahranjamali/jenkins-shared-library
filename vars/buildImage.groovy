#!/usr/bin/env groovy
import com.example.Docker
def call (String imageName) {
    return new docker(this).buildDockerImage(imageName)
}
