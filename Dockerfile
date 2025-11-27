# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven files and source
COPY pom.xml .
COPY src ./src

# Build the jar (skip tests for speed)
RUN mvn clean package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Render gives the port in $PORT, so we must use it
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
