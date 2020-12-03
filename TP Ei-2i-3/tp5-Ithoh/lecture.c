/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/lecture.c         *
*                    Creation Date: November 4, 2020 10:30 AM                    *
*                    Last Updated: November 4, 2020 10:30 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                  Fonctione de lecture des fichiers laby?.txt                   *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "lecture.h"

/*
L'édition de liens se fait dans le makefile, on précise que :
- affichage.o dépend d'affichage.h
- lecture.o dépend de lecture.h
- Et labyrinthe.o dépend de affichage.h lecture.h
Les commandes pour compiler sont les suivantes : 
gcc -Wall -o affichage.o -c affichage.c
gcc -Wall -o labyrinthe.o -c labyrinthe.c
gcc -Wall -o lecture.o -c lecture.c
gcc -o labyrinthe affichage.o labyrinthe.o lecture.o -lX11 -L/usr/X11R6/lib 
*/

int Construct_Laby(char name_file[TAILLE_fichier], int laby[TAILLE_X][TAILLE_Y], int depart[2], int arrivee[2])
{
    FILE* file;
    file = fopen(name_file, "r"); // Ouverture du fichier

    if (file != NULL) // On verifie que l'ouverture s'est bien déroulée
    {
        fscanf(file, "%d %d", &depart[0], &depart[1]); // on récupère la case de départ
        fscanf(file, "%d %d", &arrivee[0], &arrivee[1]); // on récupère la case d'arrivée

        for (int i = 0; i < TAILLE_Y; i++)
        {
            for (int j = 0; j < TAILLE_X; j++)
            {
                fscanf(file, "%d", &laby[j][i]); // on récupère un a un les éléments du labyrinthe
            }
        }

        fclose(file);
        return 1; // Return 1 if successful
    }
    fclose(file);
    return 0; // Return 0 if file is NULL
}
