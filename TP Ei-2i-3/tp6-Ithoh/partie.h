/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp6-Ithoh/partie.h         *
*                    Creation Date: November 5, 2020 04:28 PM                    *
*                    Last Updated: November 5, 2020 04:28 PM                     *
*                              Source Language: cpp                              *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Header partie                                  *
*********************************************************************************/

#ifndef __PARTIE_H__
#define __PARTIE_H__

#include "carte.h"
#define SHUFFLE 10000

typedef struct{

    t_jeu main;
    int nbCartes;
    char Nom[20];

} t_main;

typedef struct {

    t_main joueur;
    t_main ordinateur;
    t_jeu pioche;
    int posPioche;

} t_partie;

int init_partie(t_partie* partie, char* Nom1, char* Nom2);
void distrib_carte(t_partie* partie, int who);
void affich_main(t_main* Main);
int calc_val_main(t_main* Main);


#endif