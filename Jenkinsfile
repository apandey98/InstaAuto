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
                bat 'mvn test'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false,
                       jdk: '',
                       results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/screenshots/*.png', allowEmptyArchive: true
        }
    }
}