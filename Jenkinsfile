pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'git@github.com:mexicochief/test.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew shadowJar' // or 'mvn package' or whatever fits your stack
            }
        }
        // Add more stages (Test, Deploy, etc.)
    }
}