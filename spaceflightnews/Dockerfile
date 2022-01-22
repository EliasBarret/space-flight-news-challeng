FROM openjdk:11
MAINTAINER Elias Barreto
COPY target/spaceflightnews-0.0.1-SNAPSHOT.jar spaceflightnews.jar
COPY src/main/resources/ src/main/resources/
ENTRYPOINT ["java", "-jar", "spaceflightnews.jar"]