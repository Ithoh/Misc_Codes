# Modèle de fichier Makefile, à adapter pour le TP

# options de compilation
CC = gcc
CCFLAGS = -Wall
LIBS = 
LIBSDIR = 

# fichiers du projet
SRC1 = jefferson_Q1.c
SRC2 = jefferson_Q2.c
SRC3 = jefferson_Q3.c
OBJ1 = $(SRC1:.c=.o)
OBJ2 = $(SRC2:.c=.o)
OBJ3 = $(SRC3:.c=.o)
EXEC1 = jefferson_Q1
EXEC2 = jefferson_Q2
EXEC3 = jefferson_Q3


# règle initiale
all: $(EXEC1) $(EXEC2) $(EXEC3)

# dépendance des .h
jefferson.o: 
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

# règles supplémentaires
clean:
	rm -f *.o
mproper:
	rm -f $(EXEC) *.o