pipeline {
    agent any
     stages {
        stage('Prepare Selenoid') {
            steps {
                sh 'docker-compose up -d'
        }
     }
     stage('Verifying Grid') {
                 steps {
                     sh 'curl http://localhost:8083/#/'
                     }
             }
          }
}