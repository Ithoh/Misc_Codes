# Modèle de fichier Makefile, à adapter pour le TP

# options de compilation
CC = gcc
CCFLAGS = -Wall
LIBS = -lm
LIBSDIR = 

# fichiers du projet
SRC = complex.c main_complex.c
OBJ = $(SRC:.c=.o)
EXEC = complex

# règle initiale
all: $(EXEC)

# dépendance des .h
complex.o: complex.h
main_complex: complex.h

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