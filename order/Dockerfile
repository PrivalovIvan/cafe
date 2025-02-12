FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"
WORKDIR /cafe/order
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build -x test  --no-daemon



FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/order/build/libs/order_service-0.0.1-SNAPSHOT.jar order.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "order.jar"]