FROM openjdk:8-jdk-alpine
RUN apk add curl jq
WORKDIR /Users/tsrin/workspace/GoogleAutomation5
#COPY target/selenium-docker.jar selenium-docker.jar
#COPY target/selenium-docker-tests.jar selenium-docker-tests.jar
#COPY target/libs libs
#COPY testng.xml testng.xml
ADD target/selenium-docker.jar  selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs     libs
ADD testng.xml      testng.xml
ADD healthcheck.sh  healthcheck.sh
RUN chmod +x healthcheck.sh
#RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh
ENTRYPOINT sh healthcheck.sh