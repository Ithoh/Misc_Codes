/*********************************************************************************
*                               Author: Léo Delas                                *
*         File Name: /home/leo/Documents/Info_annee_3/tp3-Ithoh/sudoku.c         *
*                    Creation Date: October 15, 2020 04:01 PM                    *
*                    Last Updated: October 15, 2020 04:02 PM                     *
*                               Source Language: c                               *
*        Repository: https://github.com/PolytechSorbonne-C/tp3-Ithoh.git         *
*                                                                                *
*                            --- Code Description ---                            *
*        Lecture d'une grille de sudoku et verification de son exactitude        *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define LARGEUR 9
#define HAUTEUR 9

int remplissage_tab(int Tab[LARGEUR][HAUTEUR]); // prototype de fonction
int affich_tab(int Tab[LARGEUR][HAUTEUR]); // prototype de fonction
int correct_tab(int Tab[LARGEUR][HAUTEUR]); // prototype de fonction
int verif_tab_lignes(int Tab[LARGEUR][HAUTEUR]); // prototype de fonction
int verif_tab_colonnes(int Tab[LARGEUR][HAUTEUR]); // prototype de fonction

int main(int argc, char const *argv[])
{
    int Tab[LARGEUR][HAUTEUR];

    remplissage_tab(Tab);
    affich_tab(Tab);
    correct_tab(Tab);
    verif_tab_lignes(Tab);
    verif_tab_colonnes(Tab);

    return EXIT_SUCCESS;
}

int remplissage_tab(int Tab[LARGEUR][HAUTEUR]) // Fonction qui rempli notre tableau avec notre fichier.txt
{
    FILE * grille = NULL;
    grille = fopen("grille.txt", "r");

    if (grille != NULL)
    {
        for (int i = 0; i < HAUTEUR; i++)
        {
            for (int j = 0; j < LARGEUR; j++)
                fscanf(grille, "%d", &Tab[i][j]);
        }
    }
    return EXIT_SUCCESS;
}

int affich_tab(int Tab[LARGEUR][HAUTEUR]) // Fonction qi affiche le tableau
{
    for (int i = 0; i < HAUTEUR; i++)
    {
        printf("-------------------------------------\n");
        for (int j = 0; j < LARGEUR; j++)
        {
            printf("| %d ", Tab[i][j]);
        }
        printf("|\n");
    }
    printf("-------------------------------------\n");
    return EXIT_SUCCESS;
}

int correct_tab(int Tab[LARGEUR][HAUTEUR]) // Fonction qui vérifie que l'on a bien des entier de 1 à 9
{
    int nb_errors = 0;

    for (int i = 0; i < HAUTEUR; i++)
    {
        for (int j = 0; j < LARGEUR; j++)
        {
            if (Tab[i][j] < 1 || Tab[i][j] > 9)
            {
                printf("Erreur ligne %d | Colonne %d, valeur incorrect %d\n", i+1, j+1, Tab[i][j]);
                nb_errors++;
            }
        }
    }

    if (nb_errors!=0) printf("Il y a un total de %d erreur(s)\n", nb_errors);

    else printf("Il n'y a pas d'erreur\n");

    return EXIT_SUCCESS;
}

int verif_tab_lignes(int Tab[LARGEUR][HAUTEUR]) // Fonction qui vérifie que l'on a 1 entier différent par ligne
{
    for (int i = 0; i < HAUTEUR; i++)
    {
        for (int j = 0; j < LARGEUR-1; j++)
        {
            for (int x = j+1; x < LARGEUR; x++)
            {
                if (Tab[i][j] == Tab[i][x])
                {
                    printf("Le nombre %d est apparu plusieurs fois sur la ligne %d\n",Tab[i][j], i+1);
                }
            }
        }
    }
    return EXIT_SUCCESS;
}

int verif_tab_colonnes(int Tab[LARGEUR][HAUTEUR]) // Fonction qui vérifie que l'on a 1 entier différent par colonne
{
    for (int i = 0; i < LARGEUR; i++)
    {
        for (int j = 0; j < HAUTEUR-1; j++)
        {
            for (int x = j+1; x < HAUTEUR; x++)
            {
                if (Tab[j][i] == Tab[x][i])
                {
                    printf("Le nombre %d est apparu plusieurs fois sur la colonne %d\n",Tab[j][i], i+1);
                }
            }
        }
    }
    return EXIT_SUCCESS;
}