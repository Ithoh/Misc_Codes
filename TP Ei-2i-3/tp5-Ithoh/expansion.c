/*********************************************************************************
*                              Author: Author Name                               *
*       File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/expansion.c        *
*                    Creation Date: November 4, 2020 12:06 PM                    *
*                    Last Updated: November 4, 2020 12:06 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                Fonction de recherche de la sortie du labyrinthe                *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "expansion.h"
#include "move.h"
#include "affichage.h"
#include "remonte.h"

int expansion(int Laby[TAILLE_X][TAILLE_Y], int start[2], int end[2])
{
    int x,y,i,flag;

    x = start[0];
    y = start[1];
    Laby[x][y] = 1;

    i = 2;

    while (Laby[end[0]][end[1]] == 0) // Tant que la case actuelle n'est pas celle de fin
    {
        for (int a = 0; a < TAILLE_Y; a++)
        {
            for (int b = 0; b < TAILLE_X; b++) // On parcours le labyrinthe
            {
                if (Laby[b][a] == i - 1) // Si on trouve une case d'indice i on peux alors regarder ses cases adjacentes
                {
                    int at, bt;
                    at = a;
                    bt = b;
                    
                    for (int d = 0; d < 4; d++) // On regarde dans les quatres directions
                    {
                        deplacement(&bt, &at, d);

                        if (Laby[bt][at] == -1) // C'est un mur
                        {
                            at = a;
                            bt = b;
                        }
                        else if (Laby[bt][at] == 0) // C'est une case libre on y inscris alors l'indice auquel on se situe
                        {
                            Laby[bt][at] = i;
                            at = a;
                            bt = b;
                        }
                        else // Si c'est une case deja visitée on ne fait rien
                        {
                            at = a;
                            bt = b;
                        }
                    }
                    flag = i;
                }
            }
        }

       if (i != flag) // Pas d'issue au labyrinthe
            return 0;

        i++;

        afficheLabyrinthe(Laby,start,end,50);
    }

    Laby[end[0]][end[1]] = i; // on inscrit la dernière valeur de i dans la case d'arrivée

    return i;
}