FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar

ENV REDIS_HOST="localhost"
ENV REDIS_PORT=6380
ENV REDIS_PW="blabla"
ENV REDIS_TIMEOUT=20000

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]