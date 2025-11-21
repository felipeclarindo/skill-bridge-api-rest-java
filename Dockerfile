# ====== Etapa 1: Build com Maven + Java 21 ======
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY . .
RUN mvn -q clean package -DskipTests


# ====== Etapa 2: Runtime com Java 21 ======
FROM eclipse-temurin:21-jdk
WORKDIR /workspace

COPY --from=build /workspace/target/*.jar app.jar

ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
