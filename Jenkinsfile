pipeline {
    agent any

    environment {
        // Explicitly map your Maven directory path to resolve the command line error
        MAVEN_HOME = 'C:\\Program Files\\apache-maven-3.9.16'
        // Map your exact JDK installation directory
        JAVA_HOME  = 'C:\\Program Files\\Java\\jdk-21.0.11'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/veena-bharata/RestAssured'
            }
        }

        stage('Execute API Tests') {
            steps {
                // Injects Maven and Java binary pathways directly into the active terminal session
                withEnv(["PATH+MAVEN=${env.MAVEN_HOME}\\bin", "PATH+JAVA=${env.JAVA_HOME}\\bin"]) {
                    bat 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
