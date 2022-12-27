COMANDOS DOCKERS


1. construir y armmar el Dockerfile
2. docker ps -a     = lista contenedores
3. docker images    = lista imagenes
4. docker build -t #nameImagem# .   = construir la imagen
5. docker run #IDImage#     = ejecutar un contenedor en base a una imagen
6. docker rm #IDContainer# #IDContainer2#      = eliminar contenedor
7. docker rmi #IDImage1# #IDImage2#     = eliminar imagenes
8. docker run #IDImage#                 = eliminar containers
9. docker stop #IDImage1# #IDImage2#    = detener containers
10. docker pull

#EJECUTAR DOCKER DE UN MICROSERVICIO
$ docker run -p 8101:8001 e5c85f41240f


#EJECUTAR POSTGRES DESDE DOCKER#
docu: https://stackoverflow.com/questions/37099564/docker-how-can-run-the-psql-command-in-the-postgres-container
$ docker pull postgres
      start a postgres instance
$ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
    (The default postgres user and database are created in the entrypoint with initdb.)

$ docker run --name postgress-omar-local -e POSTGRES_PASSWORD=123456 -d postgres
    pass: 123456

$ docker exec -it postgress-omar-local psql -U postgres -W 123456

$ docker exec -it #idContainer# psql -U postgres    = entra la consola de postgres
    postgres=#  \list           = lista las BD actuales

$ docker inspect #IDContainer#      = inspeccionar detalle de un container

$ docker exec -it #idcontainer# sh

$ docker logs #idcontaier# -f (-f para ver log en vivo)

$ docker start #idcontainer# -d (para ver log al iniciar POD)


#EJECUTAR POSTGRES INSTALADA EN LA MACBOOK#
docu: https://www.neoguias.com/como-conectarse-postgresql-desde-linea-comandos/

1. Ir a la ruta /Library/PostgreSQL/11/bin/psql y ejecutar 
   

$ psql BASE_DE_DATOS NOMBRE_USUARIO     -> password (123456)

$ /Library/PostgreSQL/11/bin/psql #database name# #database user#

$ /Library/PostgreSQL/11/bin/psql msvc_cursos postgres

COMANDOS PLSQL consola
- Para ver la ayuda de psql escribe \?
- Para ver la ayuda referente a las sentencias SQL escribe \h
- Para obtener información acerca de la conexión actual, escribe \conninfo.
- Para ver un listado con todas las tablas de la base base de datos escribe \dt.
- Para ver un listado con todas las tablas, vistas y secuencias escribe \z.
- Para salir de psql escribe \q.


# DATOS
1. el comando ENTRYPOINT            solo ejecuta cuando se ejecuta el contenedor de la imagen, al ejecutar el docker run a la imagen creada.
Ej: java -jar #nombreJar.jar
2. Cada instruccion dentro del dockerfile es una capa q se genera para la imagen, 
   y estas capas se almacena en cache para que luego sea ejecutada desde la cache y asi su ejecucion sea mas rapida

$ docker --help 
# COMANDOS DOCKER IMAGENES
$ docker images prune
$ docker image prune
# eliminar contenedor al stopearlo
$ docker$ docker run --rm -p 8101:8001 e5c85f41240f (--rm elimina container cuando ejeuctar docker stop)
# entrar de manera interactiva al POD
$ docker run -p 8001:8001 --rm -it usuarios /bin/sh   
    (-it /bin/sh    -> para que entre al POD directamente, el Dockerfile tiene q estar en CMD en vez de ENTRYPOINT)

# crea imagen en base a un Dockerfile
$ docker build -t usuarios . -f ./msvc-usuarios/Dockerfile

# COMANDOS DOCKER CONTENEDORES 
$ docker rm -f #id1# #id2# #id3#  (-f -> force)
$ docker container prune (elimina container detenidos)

#copiando archivo desde pc local hacia el pod
$ docker cp ./Login.java ##idContainer:/app/Login.java
$ docker cp ./Login.java 5807376c1c18:/app/Login.java

#copiando archivo desde el pod hacia pc local
$ docker cp 5807376c1c18:/app/Login.java .\Login2.java  (copiar archivo)
$ docker cp 5807376c1c18:/app .\Test  (copiar el contenido del folder app al nuevo folder Test)

#copiando log del microservicio del POD hacia PC local
1. configurar .yml  logging.file.path = /app/logs
2. en dockerfile crear un folder /app/logs
3. ejecutar copiado 
$ docker cp 715c4b843943:/app/logs \logs

$ docker images inspect #idcontainer#
$ docker inspect #idcontainer#

# creando imagenes con etiquetas versionadas
$ docker build -t usuarios:v2 . -f .\msvs-usuarios\Dockerfile
$ docker run -p 8001:8001 --rm -d --name msvc-usuarios usuarios:v2  (--name establece un nombre para el POD)


