FROM adoptopenjdk/openjdk11:alpine-jre

COPY target/greeter-*.jar greeter.jar
EXPOSE 8181

ENTRYPOINT ["java","-jar","greeter.jar"]