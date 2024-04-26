FROM maven:3.9.6-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build/target/proyecto-0.0.1-SNAPSHOT.jar talara.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]