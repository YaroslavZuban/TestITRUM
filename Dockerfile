FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

FROM postgres:latest
COPY src/main/resources/db/migration/db.changelog-1.0.sql /docker-entrypoint-initdb.d/
