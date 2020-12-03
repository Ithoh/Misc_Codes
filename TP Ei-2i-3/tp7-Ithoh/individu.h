/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/individu.h        *
*                    Creation Date: December 2, 2020 10:45 AM                    *
*                    Last Updated: December 2, 2020 10:46 AM                     *
*                              Source Language: cpp                              *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                   Inidividu                                    *
*********************************************************************************/

#ifndef __INDIVIDU_H__
#define __INDIVIDU_H__

typedef struct{

    char* Nom;
    char* Prenom;
    char* Seq;
    float Similarity;

}t_indiv;

void lecture_adn(FILE * file, t_indiv* personne);
void affich_adn(t_indiv* personne);
void free_indiv(t_indiv personne);
void calculeSimilarite(t_indiv* personne, char* str);

#endif