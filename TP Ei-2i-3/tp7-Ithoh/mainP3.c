/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/mainP3.c         *
*                    Creation Date: December 3, 2020 11:21 AM                    *
*                    Last Updated: December 3, 2020 11:21 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                     mainP3                                     *
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

    t_indiv individu;

    t_indiv suspect;
    suspect.Nom = malloc(sizeof(char) * 50);
    suspect.Prenom = malloc(sizeof(char) * 50);
    suspect.Seq = malloc(sizeof(char) * 10000);
    suspect.Similarity = 0;

    while(!(feof(fichier_adn)))
    {
        lecture_adn(fichier_adn, &individu);
        calculeSimilarite(&individu, "TAAAGGCCG-TAAGTTCCAAATT");

        if (individu.Similarity > suspect.Similarity)
        {
            memcpy(suspect.Nom, individu.Nom, sizeof(char) * strlen(individu.Nom));
            memcpy(suspect.Prenom, individu.Prenom, sizeof(char) * strlen(individu.Prenom));
            memcpy(suspect.Seq, individu.Seq, sizeof(char) * strlen(individu.Seq));
            suspect.Similarity = individu.Similarity;
        }
        free_indiv(individu);   
    }
    
    printf("Le coupable est %s %s\n", suspect.Nom, suspect.Prenom);
    free_indiv(suspect);

    return 0;
}