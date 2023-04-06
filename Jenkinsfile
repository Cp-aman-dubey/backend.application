pipeline {
    agent any

    tools{
        maven '3.9.1'
    }
    stages {
         stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Cp-aman-dubey/backend.application.git']]])
                sh 'mvn clean install'
            }
        }
    }
}
