pipeline {
    agent any

    environment {
        // Set up the environment variables for Docker and Maven
        MAVEN_HOME = tool name: 'Maven 3.8.8', type: 'Maven'
        JAVA_HOME = '/opt/java/openjdk'
        DOCKER_IMAGE = 'brief_11-app'
        DOCKER_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git 'https://github.com/Rayane20777/Brief_11.git'
            }
        }

        stage('Build Maven') {
            steps {
                script {
                    // Use Maven to clean and package the project
                    sh "'${MAVEN_HOME}/bin/mvn' clean package -DskipTests"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image using the Dockerfile
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                    // Run the Docker container
                    sh "docker run -d -p 8081:8081 --name ${DOCKER_IMAGE} ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }

    post {
        always {
            // Clean up after the build, stop the container if it’s running
            sh "docker stop ${DOCKER_IMAGE}"
            sh "docker rm ${DOCKER_IMAGE}"
        }
    }
}
