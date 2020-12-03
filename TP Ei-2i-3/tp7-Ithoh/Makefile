# Modèle de fichier Makefile, à adapter pour le TP

# options de compilation
CC = gcc
CCFLAGS = -Wall -g
LIBS =
LIBSDIR = 

# fichiers du projet
SRC1 = strcmp.c
OBJ1 = $(SRC1:.c=.o)
EXEC1 = strcmp

SRC2 = individu.c score.c mainP1.c
OBJ2 = $(SRC2:.c=.o)
EXEC2 = mainP1

SRC3 = score.c mainP2.c
OBJ3 = $(SRC3:.c=.o)
EXEC3 = mainP2

SRC4 = score.c individu.c mainP3.c
OBJ4 = $(SRC4:.c=.o)
EXEC4 = mainP3

# règle initiale
all: $(EXEC1) $(EXEC2) $(EXEC3) $(EXEC4)

# dépendance des .h
strcmp.o : strcmp.h
individu.o : individu.h score.h
mainP1.o : individu.h score.h
score.o : score.h
mainP2.o : score.h
mainP3.o : score.h individu.h
# règles de compilation
%.o: %.c
	$(CC) $(CCFLAGS) -o $@ -c $<
	
# règles d'édition de liens
$(EXEC1): $(OBJ1)
	$(CC) -o $@ $^ $(LIBS) $(LIBSDIR)

$(EXEC2): $(OBJ2)
	$(CC) -o $@ $^ $(LIBS) $(LIBSDIR)

$(EXEC3): $(OBJ3)
	$(CC) -o $@ $^ $(LIBS) $(LIBSDIR)

$(EXEC4): $(OBJ4)
	$(CC) -o $@ $^ $(LIBS) $(LIBSDIR)
# règles supplémentaires
clean:
	rm -f *.o
mproper:
	rm -f $(EXEC1) *.o
	rm -f $(EXEC2) *.o
	rm -f $(EXEC3) *.o
	rm -f $(EXEC4) *.o