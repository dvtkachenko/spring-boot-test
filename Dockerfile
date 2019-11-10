FROM java:8-jdk-alpine
COPY ./target/boot-0.1.0.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "boot-0.1.0.jar"]