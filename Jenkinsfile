pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK25'
    }

    stages {

        stage('Clean & Build') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                script {

                    bat 'mvn test || exit 0'
                }
            }
        }
    }

    post {
        always {

            archiveArtifacts artifacts: 'target/screenshots/*.png', allowEmptyArchive: true


            allure includeProperties: false,
                   jdk: '',
                   results: [[path: 'target/allure-results']]
        }
    }
}