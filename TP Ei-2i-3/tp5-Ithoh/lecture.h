/*********************************************************************************
*                              Author: Author Name                               *
*       File Name: /home/leo/Documents/Info_Annee_3/tp5-Ithoh/lecture.h          *
*                    Creation Date: November 4, 2020 10:25 AM                    *
*                    Last Updated: November 4, 2020 10:26 AM                     *
*                              Source Language: cpp                              *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                      Prototypes de fonctions pour le laby                      *
*********************************************************************************/

#ifndef __LECTURE_H__
#define __LECTURE_H__

#include "affichage.h"
#define TAILLE_fichier  100

int Construct_Laby(char name_file[TAILLE_fichier], int laby[TAILLE_X][TAILLE_Y], int depart[2], int arrivee[2]);

#endif