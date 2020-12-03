/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/mainP1.c         *
*                    Creation Date: December 2, 2020 11:29 AM                    *
*                    Last Updated: December 2, 2020 11:29 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                    Main P1                                     *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "individu.h"
#include "score.h"

int main(int argc, char const *argv[])
{
    FILE* fichier_adn;
    if((fichier_adn = fopen("ADN.txt","r")) == NULL)
        return EXIT_FAILURE;

    t_indiv individu[10];

    for (int i = 0; i < 10; i++)
        lecture_adn(fichier_adn, &(individu[i]));


    for (int i = 0; i < 10; i++)
    {
        calculeSimilarite(&(individu[i]), "TAAAGGCCG-TAAGTTCCAAATT");
    }

    for (int i = 9; i >= 0; i--)
    {
        affich_adn(&(individu[i]));
        free_indiv(individu[i]);
    }
    
    return 0;
}
