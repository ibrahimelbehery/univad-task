pipeline {
    agent any
    stages {
        stage('Pull from Git') {
            steps {
                git branch: 'main', url: 'https://github.com/ibrahimelbehery/univad-task.git'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn -f ./chat/pom.xml clean install'
            }
        }
        stage('Deploy application') {
            steps {
                sh '''
                rm -rf /build/java/*.jar
                scp /chat/target/*.jar /build/java/
                docker-compose -f docker-compose.yml up -d'
                   '''
            }
          post {
                success {
                    echo 'success...'
                }

                failure {
                    echo 'failure '
                }
        }
    }
}
