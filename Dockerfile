FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY target/Docker-Demo-0.0.1-SNAPSHOT.jar Docker-Demo-0.0.1-SNAPSHOT.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","Docker-Demo-0.0.1-SNAPSHOT.jar"]