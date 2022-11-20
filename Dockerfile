FROM maven:3.8.5-openjdk-11 AS base
WORKDIR /app
COPY . .

FROM base AS test
CMD mvn test

FROM base AS build
RUN ["mvn", "install", "-Dmaven.test.skip=true"]

FROM adoptopenjdk/openjdk11:alpine-jre AS execution
COPY --from=build /app/target/spring-rest-weather.jar spring-rest-weather.jar
ENTRYPOINT ["java","-jar","spring-rest-weather.jar"]