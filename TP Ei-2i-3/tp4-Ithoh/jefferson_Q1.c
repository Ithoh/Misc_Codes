/*********************************************************************************
*                               Author: Léo Delas                                *
*            File Name: /home/leo/Documents/Info_annee_3/jefferson_Q1.c          *
*                    Creation Date: October 29, 2020 02:24 PM                    *
*                    Last Updated: October 29, 2020 02:25 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/tp4-Ithoh                    *
*                                                                                *
*                            --- Code Description ---                            *
*                             Jefferson cypher wheel                             *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define N 19 // Nombre de colonnes
#define L 26 // Nombre de lignes

int LitCylindre(char Tab[N][L]); // Prototypes de fonctions
int AfficheCylindre(char Tab[N][L]);

int main(int argc, char const *argv[]) // Fonction principale
{
    char Tab[N][L];

    LitCylindre(Tab);
    AfficheCylindre(Tab);

    return 0;
}

int LitCylindre(char Tab[N][L]) // Fonction qui rempli le tableau
{
    FILE * grille = NULL;
    grille = fopen("jefferson.txt", "r");

    if (grille != NULL)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < L; j++)
                fscanf(grille, "%c", &Tab[i][j]);
        }
    }
    fclose(grille);
    return EXIT_SUCCESS;
}

int AfficheCylindre(char Tab[N][L]) // Affichage du cylindre de jefferson
{
    for (int i = 0; i < L; i++)
    {
        for (int j = 0; j < N; j++)
            printf("%c ", Tab[j][i]);

        printf("\n");
    }
    return EXIT_SUCCESS;
}