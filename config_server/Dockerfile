FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"

WORKDIR /cafe/config_server

COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build --no-daemon


FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/config_server/build/libs/config_server-0.0.1-SNAPSHOT.jar config_server.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar" , "config_server.jar"]

