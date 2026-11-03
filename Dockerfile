FROM maven:3-eclipse-temurin-26-alpine AS builder
WORKDIR /app
COPY ../pom.xml .
RUN mvn dependency:go-offline -B
COPY ../src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:26-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]
