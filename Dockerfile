FROM amazoncorretto:11-alpine-jdk

COPY target/proyecto-0.0.1-SNAPSHOT.war talara.war

ENTRYPOINT ["java" , "-jar" , "/talara.war"]