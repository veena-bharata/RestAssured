pipeline {
    agent any

    // REMOVED: The strict tools block has been removed so Jenkins 
    // uses your system's global 'mvn' and 'java' path variables natively.

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/veena-bharata/RestAssured'
            }
        }

        stage('Execute API Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
