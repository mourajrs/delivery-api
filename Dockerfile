# Stage 1: Build com Maven e Java 24
# FROM maven:3.9.11-eclipse-temurin-24-noble AS build
FROM maven:3.9.11-amazoncorretto-24-al2023 AS build
WORKDIR /app

# Copia o pom e a pasta src
COPY pom.xml .
COPY src ./src

# Build do projeto sem rodar testes
RUN mvn clean package -DskipTests

# Stage 2: Run com OpenJDK 24
# FROM eclipse-temurin:24-jdk
FROM eclipse-temurin:8u462-b08-jre-windowsservercore-ltsc2025
WORKDIR /app

# Copia o jar do stage de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
