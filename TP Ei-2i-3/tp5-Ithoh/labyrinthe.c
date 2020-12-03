/*********************************************************************************
*                              Author: Author Name                               *
*       File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/labyrinthe.c       *
*                    Creation Date: November 4, 2020 08:52 AM                    *
*                    Last Updated: November 4, 2020 08:53 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/PolytechSorbonne-C/tp5-Ithoh       *
*                                                                                *
*                            --- Code Description ---                            *
*                                      Laby                                      *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "affichage.h"
#include "lecture.h"
#include "move.h"
#include "expansion.h"
#include "remonte.h"

int main(int argc, char const *argv[]) // Fonction principale de notre labyrinthe
{
    int start[2];
    int end[2];
    int Lab[TAILLE_X][TAILLE_Y];
    int ans;

    Construct_Laby("laby2.txt",Lab,start,end); // On appel la fonction pour construire le labyrinthe

    if (initAffichage()) // On initie l'affichage, et on verifie qu'il se passe bien
        printf("Init Success !\n");
    else
    {
        printf("Init Error !\n");
        return EXIT_FAILURE;
    }

    ans = expansion(Lab, start, end); // On parcours le labyrinthe a la recherche de la sortie

    if (ans != 0)
        printf("Il y a une issue au labyrinthe \n"); // Si on nous retourne une valeur différente de 0, il y a lors une issue
    else
        printf("Il n'y a pas d'issue au labyrinthe \n"); // Si on nous retourne 0, il n'y a pas d'issue au labyrinthe
    
    remonte(ans, Lab, start, end); // On remonte le labyrinthe par un des chemins les plus court

    return EXIT_SUCCESS;
}
