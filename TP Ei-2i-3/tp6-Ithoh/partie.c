/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp6-Ithoh/partie.c         *
*                    Creation Date: November 5, 2020 04:28 PM                    *
*                    Last Updated: November 5, 2020 04:28 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                     Partie                                     *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "carte.h"
#include "partie.h"

/*
    Fonction qui initialise une partie de blackjack entre deux joueurs
    Cette fonction prend en paramètre une partie de type t_partie*, et
    deux chaines de caratères de taille 20 correspondant aux noms des
    joueurs
*/
int init_partie(t_partie* partie, char Nom1[20], char Nom2[20])
{
    fill_deck(&(partie->pioche));               // On rempli la pioche
    shuffle(&(partie->pioche), SHUFFLE);        // On mélange la pioche 10000 fois -> partie.h pour changer cette valeur
    partie->posPioche = 0;                      // On indique que la pioche commence a l'indice 0

    empty_deck(&(partie->joueur.main));         // On vide la main du joueur
    partie->joueur.nbCartes = 0;                // Le joueur 1 possède 0 cartes
    empty_deck(&(partie->ordinateur.main));     // On vide la main de l'autre joueur
    partie->ordinateur.nbCartes = 0;            // Le joueur 2 possède 0 cartes

    strcpy((partie->joueur.Nom), Nom1);         // On rempli le nom du joueur 1
    strcpy((partie->ordinateur.Nom), Nom2);     // On rempli le nom du joueur 2

    return 1;
}


/*
    Fonction qui permet de piocher une carte dans la pioche, indiquer via
    un entier (0 ou 1) qui doit piocher une carte
*/
void distrib_carte(t_partie* partie, int who) // who = 0 -> Ordinateur / Who = 1 -> Joueur
{
    if (who) // who == 1
    {
        partie->joueur.main.cartes[partie->joueur.nbCartes] = partie->pioche.cartes[partie->posPioche];
        partie->posPioche++;
        partie->joueur.nbCartes++;
    }
    else if(!(who)) // who == 0
    {
        partie->ordinateur.main.cartes[partie->ordinateur.nbCartes] = partie->pioche.cartes[partie->posPioche];
        partie->posPioche++;
        partie->ordinateur.nbCartes++;
    }
    else;
}

/*
    Fonction qui affiche la main d'un joueur, elle prend en paramètre la main
    d'un des joueur (&(Partie.joueur))
*/
void affich_main(t_main* Main)
{
    for (int i = 0; i < Main->nbCartes; i++)
        affich_carte(&(Main->main.cartes[i]));
    printf("\n");
}

/*
    Fonction qui calcule la valeur d'une main donnée (&(Partie1.joueur/ordinateur))
    et elle renvoie sous forme d'entier la valeur de la main
*/
int calc_val_main(t_main* Main)
{
    int val_main = 0;

    for (int i = 0; i < Main->nbCartes; i++)
        val_main = val_main + Main->main.cartes[i].valeur;

    return val_main;
}