#Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-alpine
WORKDIR /ap
COPY --from=build /app/target/ToDo-App.jar /app/ToDo-App.jar
# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/ToDo-App.jar"]
