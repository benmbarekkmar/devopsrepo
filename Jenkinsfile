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
                sh '''mvn clean package -DskipTests'''
            }
        }

       stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
            }
        }
    }
}
