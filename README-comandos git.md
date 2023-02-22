# **CAMBIAR DE COMMIT**

$ git log --oneline

### 1. GIT RESET HARD

1. elimina los cambios actuales sin comitear y vuelve al ultimo commit forzozamente (si no comiteamos nada, se perderán los cambios) 
- $ git reset --hard
   
2. elimina el ultimo commit en el working directory y retorna al penultimo commit.
- $ git reset --hard HEAD^

### 2. GIT RESET SOFT
Sirve para cambiar a un commit SHA en especifico. 
La diferencia es que vuelve a un commit en especifico pero mantiene los cambios en el Working directory (localhost)

- $ git reset --soft #idcomit#

es recomendable usar el reset --soft en vez de usar el reset --hard

### 3. GIT REVERT
Revierte el commit actual, pero agrega un nuevo commit con su reversion. Y como parametro
se le manda el commit a donde quiere ser revertido. 
Al revertir a un commit especifico no elimina ningun cambio del Working directory y hace un merge automatico,
sino se tiene que hacer manual.

El REVERT es para mantener los cambios en el history.

- $ git revert #idcommit#
- $ git revert --continue

FUSIONAR RAMAS
$ feature> git rebase master  (oculta los commits de la rama feature, y trae los commits de master, y al final pone los commits ocultos al inicio)
$ git merge feature (al final hace un merge con feature pero de forma fast-forward)

### MODIFICAR MENSAJE DE UN COMMIT EXISTENTE
ver commits con archivos modificados
- $ git log --stat

agregar archivos  aun commmit
$ git commit --no-edit --amend


### AGREGAR ARCHIVOS A COMMITS YA EXISTENTES
ver commits con archivos modificados
- $ git log --stat

agregar archivos  aun commmit
$ git commit --no-edit --amend

---
###GIT REBASE
Nos permite modificar cualquier commit de forma individua, es decir modifica el historial de commits eliminando, dividiendo y modificando los commits existentes.
No solo modifica el ultimo commit, sino nos da la posibilidad de actualizar cualquier commit. 
> $ git rebase -i HEAD~2
> el git rebase temuestra los commits de manera inversa como te los muestra el git log
> $ esc + i
> $ escribir 'edit' en el commit que quieres modificar el mensaje
> $ git commit -m "update commit ciwht rebase" --amend
> $ git rebase --continue
> $ git log --oneline 
>




