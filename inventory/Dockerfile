FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"
WORKDIR /cafe/inventory
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build -x test  --no-daemon



FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/inventory/build/libs/inventory_service-0.0.1-SNAPSHOT.jar inventory.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "inventory.jar"]