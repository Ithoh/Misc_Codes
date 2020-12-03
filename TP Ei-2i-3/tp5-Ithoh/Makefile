# Modèle de fichier Makefile, à adapter pour le TP

# options de compilation
CC = gcc
CCFLAGS = -Wall -g
LIBS = -lX11 -L/usr/X11R6/lib
LIBSDIR = 

# fichiers du projet
SRC = affichage.c labyrinthe.c lecture.c move.c expansion.c remonte.c
OBJ = $(SRC:.c=.o)
EXEC = labyrinthe

# règle initiale
all: $(EXEC)

# dépendance des .h
expansion.o: expansion.h move.h remonte.h
remonte.o: remonte.h move.h
lecture.o: lecture.h
move.o: move.h
labyrinthe.o: lecture.h move.h expansion.h remonte.h
# règles de compilation
%.o: %.c
	$(CC) $(CCFLAGS) -o $@ -c $<
	
# règles d'édition de liens
$(EXEC): $(OBJ)
	$(CC) -o $@ $^ $(LIBS) $(LIBSDIR)

# règles supplémentaires
clean:
	rm -f *.o
mproper:
	rm -f $(EXEC) *.o