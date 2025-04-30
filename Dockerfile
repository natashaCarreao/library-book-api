FROM azul/zulu-openjdk-alpine:21-jre-headless-latest
LABEL org.opencontainers.image.authors="nta.13@live.com"
COPY ./build/libs/library-book-api-0.0.1-SNAPSHOT.jar /app/library-book-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "library-book-api-0.0.1-SNAPSHOT.jar"]