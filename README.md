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

$ docker exec -it postgress-omar-local psql -U postgres msvc_cursos
$ docker exec -it serverPostgresDocker psql -U postgres msvc_cursos
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

COMANDO PARA DETENER PSQL DE LA MAC
$ sudo -u postgres /Library/PostgreSQL/11/bin/pg_ctl -D /Library/PostgreSQL/11/data stop
COMANDO PARA EMPEZAR PSQL DE LA MAC
$ sudo -u postgres /Library/PostgreSQL/11/bin/pg_ctl -D /Library/PostgreSQL/11/data start

# DATOS
1. el comando ENTRYPOINT -> solo ejecuta cuando se ejecuta el contenedor de la imagen, al ejecutar el docker run a la imagen creada.
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
$ docker build -t cursos . -f ./msvc-cursos/Dockerfile

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
$ docker run -p 8001:8001 --rm -d --network spring --name msvc-usuarios usuarios   (--name establece un nombre para el POD)
$ docker run -p 8002:8002 --rm -d --network spring --name msvc-cursos cursos 

# instalar MYSQL en docker desktop
# trae la imagen
$ docker pull mysql:8
# ejecuta el docker run para el mysql
$ docker run -p #port externo#:5432 --name #nameServer# --network #nameRed# -e POSTGRES_PASSWORD=#password# -e POSTGRES_DB=#nameBD# -d #nameImagen:version#
$ docker run -p 33060:3306 --name mysql-db --network spring -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios -d mysql:8

# instalar POSTGRES en docker desktop
# trae la imagen
$ docker pull postgres:14-alpine
# ejecuta el docker run para el postgres
$ docker run -p #port externo#:5432 --name #nameServer# --network #nameRed# -e POSTGRES_PASSWORD=#password# -e POSTGRES_DB=#nameBD# -d #nameImagen:version#
$ docker run -p 5532:5432 --name serverPostgresDocker --network spring -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -d postgres:14-alpine


# PASSWORD MASTER POSTGRES -> 123456

# CREAR VOLUMENES
$ docker volume create mysql-volume
$ docker volume create postgres-volume
$ docker volume inspect mysql-volume

# EJECUTAR BASE DE DATOS CON VOLUMENES PARA PERSISTIR LA DATA
# en la ruta del docker mysql guarda la info de la BD en: /var/lib/mysql (esta en la documentacion)
$ docker run -p 33060:3306 --name mysql-db --network spring -e MYSQL_ROOT_PASSWORD=sasa -e MYSQL_DATABASE=msvc_usuarios  -v data-mysql:/var/lib/mysql --restart=always -d mysql:8
$ docker run -p 5532:5432 --name serverPostgresDocker --network spring -e POSTGRES_PASSWORD=sasa -e POSTGRES_DB=msvc_cursos -v data-postgres2:/var/lib/postgresql/data --restart=always -d postgres:14-alpine

# ENTRAR AL DOCKER DE MYSQL
$ docker exec -it #idcontainer# bash
$ mysql -hmysql-db -uroot -p
 -> ingresa password -> sasa \n
 mysql> show databases; \n
 mysql> \q  (salir de consola)


# AUTENTICAR POR SSH DESDE GITHUB - LISTA DE PASOS - DOCUMENTACION
https://docs.github.com/es/authentication/connecting-to-github-with-ssh

# DOCKER: ARGUMENTS AND ENVIRONMENT VARIABLES
# seteando valores ENV en Dockerfile and properties
- .properties
    server.port=${PORT:8001}
- Dockerfile
    ENV PORT 8002
    EXPOSE $PORT
  
# sobreescribir variable ENV en el momento del despliegue, en tiempo de ejecucion
8001:8090  (8001 -> puerto externo, y 8090 -> puerto interno que usa la aplicacion)
$ docker run -p 8001:8090 --env PORT=8090 --rm -d --network spring --name msvc-usuarios usuarios 
$ docker run -p 8002:8091 --env PORT=8091 --rm -d --network spring --name msvc-cursos cursos

# otra alternativa es externeliza las variables de entorno a un archivo por fuera
- creamos un archivo .env
    PORT=8091  (8092)
- el -p 8001:8090 lo que hace es abrir los puertos de comunicacion tanto hacia adentro como hacia afuera  
$ docker run -p 8001:8091 --env-file ./msvc-usuarios/.env --rm -d --network spring --name msvc-usuarios usuarios
$ docker run -p 8002:8092 --env-file ./msvc-cursos/.env --rm -d --network spring --name msvc-cursos cursos

# ARGUMENTOS -> Se usan solo en el dockerfile, los argumento son como variable que se usaran dentro de un dockerfile
$ ARG PORT_APP=8001
# AL EJECUTAR LA IMAGEN SOBRE ESCRIBIR LA VARIABLE DE ARGUMENTO
$ docker build -t usuarios . -f ./msvc-usuarios/Dockerfile --build-arg PORT_APP=8080  
  (quiere decir que el puerto interno será seteando al momento de construir la imagen)

# LOS ARGUMENTS se usan para construccion de imagenes, se usan en los Dockerfile
# LOS ENVIROONMENTS se usan para contruccion de contenedores, Sus variables se pueden usar en los properties o en los yml

# USAR LOS ARGUMENTS EN MULTISTAGE 
Se declaran al inicio como variable global, y luego en cada FROM se van usando VAR MSVC_NAME

`$ docker build -t usuarios . -f ./msvc-usuarios/Dockerfile`

`$ docker build -t cursos . -f ./msvc-cursos/Dockerfile`

`$ docker run -p 9001:8001 --rm -d --network spring --name msvc-usuarios usuarios`

`$ docker run -p 9002:8002 --rm -d --network spring --name msvc-cursos cursos`

# EJECUTAR DOCKER RUN CON VARIABLES DE ENTORNO DE BASE DE DATOS Y PUERTOS
`$ docker run -p 9001:8001 --env-file ./msvc-usuarios/.env --rm -d --network spring --name msvc-usuarios usuarios` 

`$ docker run -p 9002:8002 --env-file ./msvc-cursos/.env --rm -d --network spring --name msvc-cursos cursos`


# DOCKER COMPOSE  (docker-compose.yml)
$ docker-compose up -d
$ docker-compose down
$ docker-compose down -v  (con -v tb va a eliminar los volumenes)

# VOLVER A CONSTRUIR IMAGENES DESDE EL DOCKER-COMPOSE
$ docker-compose up --build -d

# DOCKER HUB
$ docker login
$ docker logout
$ docker tag usuarios calderonomar48/usuarios-udemy
$ docker push calderonomar48/usuarios-udemy
$ docker tag cursos calderonomar48/cursos-udemy
$ docker push calderonomar48/cursos-udemy

# RECUPERAR IMAGEN DE UN DOCKER HUB
$ docker pull calderonomar48/usuarios-udemy
$ docker pull calderonomar48/cursos-udemy


1
2

