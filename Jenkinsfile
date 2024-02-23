pipeline {
    agent any
     stages {
        stage('Prepare Selenoid') {
            steps {
                sh 'docker pull aerokube/selenoid:latest'
                sh 'docker pull aerokube/cm:latest'
                sh 'docker pull aerokube/selenoid-ui:latest'
                sh 'docker pull selenoid/vnc_chrome:120.0'
                sh 'docker run --name selenoid -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v $PWD/config/:/etc/selenoid/:ro aerokube/selenoid'
                sh 'curl http://localhost:4444/status'
            }
        }
     }
}