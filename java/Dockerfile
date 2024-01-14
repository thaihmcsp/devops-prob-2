# Stage 1: Build the application
FROM openjdk:11-jdk AS builder

WORKDIR /app

COPY . .

RUN /bin/bash -c './gradlew build'

# Stage 2: Run the application
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
