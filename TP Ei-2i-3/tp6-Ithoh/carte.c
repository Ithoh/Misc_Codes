/*********************************************************************************
*                              Author: Author Name                               *
*       File Name: /home/leo/Documents/Info_Annee_3/tp6-Ithoh/blackjack.c        *
*                    Creation Date: November 5, 2020 01:54 PM                    *
*                    Last Updated: November 5, 2020 01:54 PM                     *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp6-Ithoh/          *
*                                                                                *
*                            --- Code Description ---                            *
*                              Fonctions blackjack                               *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "carte.h"

/*
    Affiche une carte à jouer de type t_carte*
*/
void affich_carte(t_carte* carte1)
{
    if (carte1->valeur == 1)
        printf("  A"); // As
    else if (carte1->valeur == 11)
        printf("  V"); // Valet
    else if (carte1->valeur == 12)
        printf("  D"); // Damet
    else if (carte1->valeur == 13)
        printf("  R"); // Roi
    else
        printf("  %d", carte1->valeur); // Valeur comprise entre 2 et 10

    switch (carte1->couleur)
    {
    case PIQUE:
        printf("\u2660"); // Print le symbole pique
        break;
     case COEUR:
        printf("\u2665"); // Print le symbole coeur
        break;   
    case CARREAU:
        printf("\u2666"); // Print le symbole carreau
        break;
    case TREFLE:
        printf("\u2663"); // Print le symbole trefle
        break;
    }
}


/*
    Remplissage d'un deck de cartes, le deck contient
    52 cartes, le deck est de type t_jeu*
*/
void fill_deck(t_jeu* Deck)
{
    t_carte Carte;
    int i;
    i = 0;

    for (int couleur = 0; couleur < 4; couleur++)
    {
        for (int valeur = 1; valeur < 14; valeur++)
        {
            Carte.valeur = valeur;
            Carte.couleur = couleur;

            Deck->cartes[i] = Carte;

            i++;
        }
    }
}

/*
    Vide un deck de cartes pour faire en sorte qu'il n'y
    est pas de cartes à l'intérieur, le deck est de type
    t_jeu*
*/
void empty_deck(t_jeu* Deck)
{
    t_carte Carte;
    int i;
    i = 0;

    for (int couleur = 0; couleur < 4; couleur++)
    {
        for (int valeur = 1; valeur < 14; valeur++)
        {
            Carte.valeur = 0;
            Carte.couleur = 0;

            Deck->cartes[i] = Carte;

            i++;
        }
    }
}


/*
    Fonction affichant un deck de cartes, le paramètre d'entrée
    est un deck de cartes de type t_jeu*
*/
void disp_deck(t_jeu* Deck)
{
    for (int i = 0; i < 52; i++)
    {
        if (i % 13 == 0 && i > 0)
            printf("\n");
        affich_carte(&(Deck->cartes[i]));

    }
    printf("\n");
}

/*
    Fonction qui mélange un deck de cartes un nombre de fois
    donné, il prend en paramètre une deck de cartes de type
    t_jeu* et un entier qui représente le nombre de mélanges
*/
void shuffle(t_jeu* Deck, int melanges)
{
    srand(time(NULL));

    t_carte temp1;
    float rand1, rand2;

    for (int i = 0; i < melanges; i++)
    {
        rand1 = ((float)rand() / RAND_MAX)*51;
        rand2 = ((float)rand() / RAND_MAX)*51;

        temp1 = Deck->cartes[(int)rand1];
        Deck->cartes[(int)rand1] = Deck->cartes[(int)rand2];
        Deck->cartes[(int)rand2] = temp1;
    } 
}