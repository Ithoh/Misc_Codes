/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/individu.c        *
*                    Creation Date: December 2, 2020 10:45 AM                    *
*                    Last Updated: December 2, 2020 10:46 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                    Individu                                    *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "individu.h"
#include "score.h"

/* Lecture dans le fichier ADN.txt de chaque personne avec sa séquence ADN */
void lecture_adn(FILE * file, t_indiv* personne)
{
    char Name[50];
    char FirstName[50];
    char ADN[10000];

    fscanf(file, "%s", Name);
    fscanf(file, "%s", FirstName);
    fscanf(file, "%s", ADN);

    size_t l = strlen(Name) + 1;
    personne->Nom = malloc(l * sizeof(char));
    strcpy(personne->Nom, Name);

    l = strlen(FirstName) + 1;
    personne->Prenom = malloc(l * sizeof(char));
    strcpy(personne->Prenom, FirstName);

    l = strlen(ADN) + 1;
    personne->Seq = malloc(l * sizeof(char));
    strcpy(personne->Seq, ADN);

}

/* Calcul des similarités entre une personne et une chaine donnée */
void calculeSimilarite(t_indiv* personne, char* str)
{
    int score = compare_adn(personne->Seq, str);
    personne->Similarity = similarity(score, minimum(strlen(personne->Seq), strlen(str)));
}

/* Affiche le nom / prenom d'une personne et sa séquence ADN */
void affich_adn(t_indiv* personne)
{
    printf("Nom : %c. %s\n", personne->Prenom[0], personne->Nom);  // Affichage nom / prenom
    printf("ADN : %s\n", personne->Seq);                          // Affichage adn
}

/* Libère un individu de sa mémoire (free malloc !) */
void free_indiv(t_indiv personne)
{
    if (personne.Nom != NULL)
        free(personne.Nom);
    if (personne.Prenom != NULL)
        free(personne.Prenom);
    if (personne.Seq != NULL)
        free(personne.Seq);
}