# 1. cambiar de commmit

$ git log --oneline

GIT RESET HARD

1. elimina los cambios actuales sin comitear y vuelve al ultimo commit forzozamente (si no comiteamos nada, se perderán los cambios)
   $ git reset --hard
   
2. elimina el ultimo commit en el working directory y retorna al penultimo commit.
$ git reset --hard HEAD^

GIT SOFT RESET: sirve para cambiar a un commit SHA en especifico. 
La diferencia es que vuelve a un commit en especifico pero mantiene los cambios en el Working directory (localhost)

$ git reset --soft #idcomit#

es recomendable usar el reset --soft en vez de usar el reset --hard

GIT REVERT: Revierte el commit actual, pero agrega un nuevo commit con su reversion. Y como parametro
se le manda el commit a donde quiere ser revertido. 
Al revertir a un commit especifico no elimina ningun cambio del Working directory y hace un merge automatico,
sino se tiene que hacer manual.
El REVERT es para mantener los cambios en el history.

$ git revert #idcommit#
$ git

cambio 1
cambio 2
