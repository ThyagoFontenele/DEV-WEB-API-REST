FROM openjdk

ADD . /app

WORKDIR /app

COPY target/eventoapi-0.0.1-SNAPSHOT.jar /app/eventoapi.jar

ENTRYPOINT ["java", "-jar", "eventoapi.jar"]

# mvn package
# docker build -t eventoapi .
# docker run -d -p 8080:8080 --name spring-app-api eventoapi