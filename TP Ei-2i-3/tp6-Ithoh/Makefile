# Modèle de fichier Makefile, à adapter pour le TP

# options de compilation
CC = gcc
CCFLAGS = -Wall -g
LIBS =
LIBSDIR = 

# fichiers du projet
SRC = carte.c blackjack.c partie.c
OBJ = $(SRC:.c=.o)
EXEC = blackjack

# règle initiale
all: $(EXEC)

# dépendance des .h
carte.o: carte.h
partie.o: partie.h carte.h
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