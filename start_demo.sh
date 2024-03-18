#!/bin/bash

chmod +x gradlew
echo "Building projects..."
./gradlew clean build

if [ $? -eq 0 ]; then
    echo "Services were built successful, starting Docker containers..."
    docker-compose up --build -d
else
    echo "Build failed, not starting Docker containers."
    exit 1
fi
