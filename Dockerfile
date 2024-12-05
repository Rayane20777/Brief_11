# Use an official Java runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/brief_11-0.0.1-SNAPSHOT.jar brief_11-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "brief_11-0.0.1-SNAPSHOT.jar"]
