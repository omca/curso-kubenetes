# declaramos variables globales
ARG MSVC_NAME=msvc-usuarios

# aqui se hará una compilacion en varias etapas, y para eso usamos el builder
FROM openjdk:17-jdk-alpine as builder
ARG MSVC_NAME
# crea esas carpetas en el docker
WORKDIR /app/$MSVC_NAME

#copiando archivos: copy a -> b
COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

# permisos para ejecutar clean package en docker
# el objetivo es ejecutar e dockerfile  en menos tiempo y con menos peso de la imagen
RUN chmod +x mvnw

#RUN es un comando que se ejecuta cuando se construye la imagen
# aqui esta ejecutando un empaquetado .jar saltandose la compilacion y ejecucion del folder test y main
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

#anteriormente creo un prebuilder (as builder), q se usará en la siguiente ejecucion
#en ese builder se genera el jar con todas sus dependencias, luego se copia solo el .jar generado
#hacia la nueva imagen

#empieza el nuevo empaquetado del JAR
FROM openjdk:17-jdk-alpine
WORKDIR /app
RUN mkdir ./logs
# copiar el JAR de la construccion anterior 'builder'
ARG MSVC_NAME
ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT
CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]