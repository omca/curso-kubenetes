COMANDOS DOCKERS


1. construir y armmar el Dockerfile
2. docker ps -a     = lista contenedores
3. docker images    = lista imagenes
4. docker build .   = construir la imagen
5. docker run #IDImage#     = ejecutar un contenedor en base a una imagen
6. docker rm #IDContainer# #IDContainer2#      = eliminar contenedor
7. docker rmi #IDImage1# #IDImage2#     = eliminar imagenes
8. docker run #IDImage#                 = eliminar containers
9. docker stop #IDImage1# #IDImage2#    = detener containers
10. docker pull

#EJECUTAR DOCKER
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



#EJECUTAR POSTGRES INSTALADA EN LA MACBOOK#
docu: https://www.neoguias.com/como-conectarse-postgresql-desde-linea-comandos/
$ psql BASE_DE_DATOS NOMBRE_USUARIO     -> password (123456)

$ /Library/PostgreSQL/11/bin/psql #database name# #database user#

$ /Library/PostgreSQL/11/bin/psql msvc_cursos postgres

COMANDOS PLSQL consola
- Para ver la ayuda de psql escribe \?.
- Para ver la ayuda referente a las sentencias SQL escribe \h.
- Para obtener información acerca de la conexión actual, escribe \conninfo.
- Para ver un listado con todas las tablas de la base base de datos escribe \dt.
- Para ver un listado con todas las tablas, vistas y secuencias escribe \z.
-  Para salir de psql escribe \q.



passssss: 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

se tiene q hacer un merge manual