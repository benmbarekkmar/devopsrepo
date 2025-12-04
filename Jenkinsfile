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

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
            }
        }

        stage('Build Docker image') {
            steps {
                sh """
                    docker build -t bensalahons/student-management:latest .
                """
            }
        }
    }

    post {

        success {
            mail to: 'kmarb.mbarek@gmail.com',
                 subject: 'Build Successful - Jenkins CI',
                 body: 'La build a réussi avec succès.\n\nBonne journée !'
        }

        failure {
            mail to: 'kmarb.mbarek@gmail.com',
                 subject: ' Build Failed - Jenkins CI',
                 body: 'La build a échoué.\n\nVeuillez vérifier le pipeline.'
        }
    }
}
