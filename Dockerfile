FROM amazoncorretto:21-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} linkmethod.jar

ENTRYPOINT ["java", "-jar", "/linkmethod.jar"]