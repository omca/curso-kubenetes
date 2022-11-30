#FROM openjdk:17.0.2
#FROM openjdk:20-slim-buster
FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar /app

EXPOSE 8001

# se va a ejecutar en algun punto de entra y ejecutammos comandos java apuntando al jar
ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]