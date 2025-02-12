FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"

WORKDIR /cafe/eureka_server

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src ./src

RUN gradle build --no-daemon

FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/eureka_server/build/libs/eureka_server-0.0.1-SNAPSHOT.jar eureka_server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka_server.jar"]