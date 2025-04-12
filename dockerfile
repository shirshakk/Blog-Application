FROM openjdk:23-jdk-slim

RUN apt-get update && \
    apt-get install -y bash && \
    rm -rf /var/lib/apt/lists/*


SHELL ["/bin/bash", "-c"]

WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]