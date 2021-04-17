FROM alpine:3.13.5

ENV JAVA_HOME="/usr/lib/jvm/default-jvm"

ARG WORKSPACE="/workspace/lordofthepushes"
ENV WORKSPACE=${WORKSPACE}

ARG DB_HOST="jdbc:postgresql://lordofthepushes-local-db:5432/lordofthepushes"
ENV DB_HOST=${DB_HOST}

ARG DB_USERNAME="lordofthepushes"
ENV DB_USERNAME=${DB_USERNAME}

ARG DB_PASSWORD="qwe123"
ENV DB_PASSWORD=${DB_PASSWORD}

WORKDIR ${WORKSPACE}

RUN apk add bash openjdk8 maven

RUN adduser --home ${WORKSPACE} --shell /bin/bash --disabled-password spring

ADD . /workspace/lordofthepushes

ADD docker/lordofthepushes-app/mvn_repo ${WORKSPACE}/.m2

RUN chown -R spring:spring ${WORKSPACE}

USER spring

RUN mvn clean compile

RUN mvn clean install -Dmaven.test.skip=true

ENTRYPOINT ["java", "-jar", "/workspace/lordofthepushes/target/lord-of-the-pushes-0.0.1-SNAPSHOT.jar"]
