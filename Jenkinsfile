pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mexicochief/Test'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh 'git add gradlew'
                sh 'git commit -m "Make gradlew executable"'
                sh 'git push'
                sh './gradlew build' // or 'mvn package' or whatever fits your stack
            }
        }
        // Add more stages (Test, Deploy, etc.)
    }
}