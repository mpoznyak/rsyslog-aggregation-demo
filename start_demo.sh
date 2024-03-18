#!/bin/bash

# Directory of your Spring Boot project
SPRING_PROJECT_PATH="/path/to/your/spring-boot-project"

# Navigate to the Spring Boot project directory
echo "Navigating to the Spring Boot project directory..."
cd $SPRING_PROJECT_PATH

# Run Gradle clean and build
echo "Building the Spring Boot project..."
./gradlew clean build

# Check if build was successful
if [ $? -eq 0 ]; then
    echo "Build successful, starting Docker containers..."
    # Navigate to the directory containing your docker-compose.yml file
    # Adjust this if your Docker Compose file is in a different location
    cd /path/to/your/docker-compose-directory

    # Start up your Docker containers
    docker-compose up --build
else
    echo "Build failed, not starting Docker containers."
    exit 1
fi
