FROM artifactory.pegadaian.co.id:8084/maven:3-jdk-8-alpine

MAINTAINER irfan

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/

RUN mvn -B clean compile
RUN mvn -B deploy

FROM artifactory.pegadaian.co.id:8084/openjdk:8-jre-alpine
WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/karyawan-maven-release*.jar /app/karyawan-maven-release.jar
ENTRYPOINT ["java", "-jar", "karyawan-maven-release.jar"]


