FROM openjdk:17-jdk-slim
#LABEL org.opencontainers.image.source=https://github.com/Scalum/workcafe
#LABEL org.opencontainers.image.description="workcafe"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]