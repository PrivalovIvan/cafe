FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"
WORKDIR /cafe/customer
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build -x test  --no-daemon



FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/customer/build/libs/customer_service-0.0.1-SNAPSHOT.jar customer.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "customer.jar"]