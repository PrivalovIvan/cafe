FROM gradle:jdk17 AS build
LABEL authors="ivanprivalov"
WORKDIR /cafe/product
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build -x test  --no-daemon



FROM openjdk
VOLUME ./tmp
COPY --from=build /cafe/product/build/libs/product_service-0.0.1-SNAPSHOT.jar product.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "product.jar"]