pipeline {
    agent any

    tools {
        // Must match the exact name of the Maven tool configured in Manage Jenkins > Tools
        maven 'Maven 3.9.16' 
        // Must match the exact name of the JDK tool configured in Manage Jenkins > Tools
        jdk 'JDK 21.0.11'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Safely pulls down the latest code updates from your GitHub repository branch
                git branch: 'main', url: 'https://github.com/veena-bharata/RestAssured'
            }
        }

        stage('Execute API Tests') {
            steps {
                // Runs the clean test execution command
                // Note: Windows nodes use 'bat', Linux/Mac nodes use 'sh'
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // This captures your TestNG results and displays a nice graph on your Jenkins dashboard
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
