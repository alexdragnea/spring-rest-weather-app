FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/war_name.war app.war
ENTRYPOINT ["java","-jar","/app.war"]