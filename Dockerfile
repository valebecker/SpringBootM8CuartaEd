FROM amazoncorretto:18

MAINTAINER valebecker

COPY target/SpringBoot-0.0.1-SNAPSHOT.jar SpringBoot-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/SpringBoot-0.0.1-SNAPSHOT.jar"]