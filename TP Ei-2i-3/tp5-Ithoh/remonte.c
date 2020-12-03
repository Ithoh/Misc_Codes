/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/remonte.c         *
*                    Creation Date: November 4, 2020 10:17 PM                    *
*                    Last Updated: November 4, 2020 10:18 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                       Fonction de remontée du labyrinthe                       *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "remonte.h"
#include "affichage.h"
#include "move.h"

int remonte(int r, int Laby[TAILLE_X][TAILLE_Y], int start[2], int end[2])
{
    int x, y, ti, tj;

    x = end[0];
    y = end[1];
    ti = x;
    tj = y;
    Laby[x][y] = -2;

    while (r != 1) // Tant que l'on est pas a la case de départ on boucle
    {
        for (int d = 0; d < 4; d++) // On recherche depuis la case d'arrivée une case adjacente correspondante r-1
        {
            deplacement(&ti, &tj, d);

            if (Laby[ti][tj] == -1) // Si c'est un mur on ignore
            {
                ti = x;
                tj = y;
            }
            else if (Laby[ti][tj] == 0) // Si c'est une case libre on ignore
            {
                ti = x;
                tj = y;
            }
            else if (Laby[ti][tj] == r-2) // Case adjacente trouvée !
            {
                Laby[ti][tj] = -2;
                x = ti;
                y = tj;
                break;
            }
            else // Si case supérieure
            {
                ti = x;
                tj = y;
            }
        }

        r--;
        afficheLabyrinthe(Laby, start, end, 50);
    }

    return 0;
}