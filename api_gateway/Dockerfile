FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"
WORKDIR /cafe/api_gateway
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build --no-daemon



FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/api_gateway/build/libs/api_gateway-0.0.1-SNAPSHOT.jar api_gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api_gateway.jar"]