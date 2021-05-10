FROM --platform=linux/amd64 openjdk:8-alpine

WORKDIR /app

COPY . .

RUN ./mvnw clean package

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/mediappbackend-0.0.1-SNAPSHOT.jar"]