FROM openjdk:17-jdk-slim

VOLUME /tmp

ARG JAR_FILE=build/libs/service-a-1.0.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]