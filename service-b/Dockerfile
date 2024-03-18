# Start with a base image containing Java runtime (adopted from official OpenJDK image for Java 17)
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp, since Spring Boot uses this location for temporary files
VOLUME /tmp

# Add the application's jar file
ARG JAR_FILE=build/libs/service-b-1.0.jar
COPY ${JAR_FILE} app.jar

# Expose the port your Spring application runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]