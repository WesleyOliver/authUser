FROM openjdk:11-jdk

WORKDIR /app

COPY target/authUser-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8087

CMD ["java", "-jar", "/app/app.jar"]