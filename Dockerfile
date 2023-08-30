#gradle 빌드
FROM gradle:jdk11-alpine AS build
#복사하면 캐시처리 되어 속도가 빨라진다
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
COPY --chown=gradle:gradle gradlew *.gradle ./
RUN gradle clean bootJar

#이미지 실행
FROM openjdk:11 AS build
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]