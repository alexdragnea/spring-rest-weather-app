FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/spring-rest-weather-0.0.1-SNAPSHOT.jar spring-rest-weather-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-rest-weather-0.0.1-SNAPSHOT.jar"]