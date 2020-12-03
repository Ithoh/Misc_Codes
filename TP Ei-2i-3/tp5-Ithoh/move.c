/*********************************************************************************
*                              Author: Author Name                               *
*          File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/move.c          *
*                    Creation Date: November 4, 2020 10:38 AM                    *
*                    Last Updated: November 4, 2020 10:39 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                              Fonction pour bouger                              *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "move.h"

void deplacement(int* px, int* py, int d) // on donne en paramètres les coordonées d'une case ainsi qu'une direction 0,1,2 ou 3 (NORD,EST,SUD,OUEST)
{
    switch (d) // Si l'on cherche a utiliser les coordonnées des cases voisines  a une case du bords on risque d'obtenir une erreur de segmentation (Question 5)
    {
    case NORD : *px = *px; --(*py);
        break;
    
    case EST : ++(*px); *py = *py;
        break;

    case SUD : *px = *px; ++(*py);
        break;

    case OUEST : --(*px); *py = *py;
        break;

    default: printf("Direction incorrecte !\n");
        break;
    }
}