pipeline {
    agent any

    stages {
       stage('Checkout') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']], 
                    extensions: [], 
                    userRemoteConfigs: [[url: 'https://github.com/benmbarekkmar/devopsrepo.git']]
                )
            }
        }

        stage('Build') {
            steps {
                sh '''mvn clean package'''
            }
        }

       stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
            }
        }

          stage('Build docker image') {
            steps {
                sh """
                    docker build -t bensalahons/student-management:latest .
                """
            }
        }
    }
}
