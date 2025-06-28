FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/stardust-1.0.0.jar /app/stardust-1.0.0.jar
ENTRYPOINT ["java", "-jar", "stardust-1.0.0.jar"]