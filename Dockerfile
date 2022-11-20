FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
WORKDIR /home/app
RUN mvn clean package


FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/Service_AND_VERSION_STUFF.jar /usr/local/lib/Service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/Service.jar"]