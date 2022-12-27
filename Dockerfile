FROM gradle:jdk17 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17-alpine
COPY --from=gradleimage /home/gradle/source/build/libs/code-challenge-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "code-challenge-0.0.1-SNAPSHOT.jar"]
