FROM maven:3.6.3-jdk-8 AS MAVEN_BUILD
MAINTAINER Diego Leonel Cañete Crescini
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/minesweeper-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "minesweeper-0.0.1-SNAPSHOT.jar"]