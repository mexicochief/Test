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

        stage('Docker Build') {
            steps {
                script {
                    sh 'docker build -t stardust:latest'
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    sh 'docker rm -f stardust || true'
                    sh 'docker run -d --name my-app -p 8080:8081 stardust:latest'
                }
            }
        }
        // Add more stages (Test, Deploy, etc.)
    }
}