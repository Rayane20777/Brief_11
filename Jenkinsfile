pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "brief_11_app" // Docker image name
        DOCKER_REGISTRY = "your-docker-registry" // Optional: Replace with your Docker registry
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Rayane20777/Brief_11.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                // Clean and package the application
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image
                sh '''
                docker build -t $DOCKER_IMAGE .
                '''
            }
        }

        stage('Run Docker Containers') {
            steps {
                // Stop and remove existing containers
                sh '''
                docker-compose down || true
                docker-compose up -d
                '''
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}
