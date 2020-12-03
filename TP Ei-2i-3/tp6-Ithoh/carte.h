/*********************************************************************************
*                              Author: Author Name                               *
*       File Name: /home/leo/Documents/Info_Annee_3/tp6-Ithoh/blackjack.h        *
*                    Creation Date: November 5, 2020 01:50 PM                    *
*                    Last Updated: November 5, 2020 01:50 PM                     *
*                              Source Language: cpp                              *
*          Repository: https://github.com/PolytechSorbonne-C/tp6-Ithoh/          *
*                                                                                *
*                            --- Code Description ---                            *
*                                Blackjack header                                *
*********************************************************************************/

#ifndef __CARTE_H__
#define __CARTE_H__

typedef enum {PIQUE, COEUR, CARREAU, TREFLE} t_couleur;

typedef struct {

    int valeur;
    t_couleur couleur;

} t_carte;

typedef struct {

    t_carte cartes[52];

}t_jeu;

#define AS      1
#define DEUX    2
#define TROIS   3
#define QUATRE  4
#define CINQ    5
#define SIX     6
#define SEPT    7
#define HUIT    8
#define NEUF    9
#define DIX     10
#define VALET   11
#define DAME    12
#define ROI     13

void affich_carte(t_carte* carte1);
void fill_deck(t_jeu* Deck);
void empty_deck(t_jeu* Deck);
void disp_deck(t_jeu* Deck);
void shuffle(t_jeu* Deck, int melanges);

#endif