/*********************************************************************************
*                               Author: Léo Delas                                *
*      File Name: /home/leo/Documents/Info_annee_3/tp4-Ithoh/jefferson_Q2.c      *
*                    Creation Date: October 29, 2020 02:56 PM                    *
*                    Last Updated: October 29, 2020 02:56 PM                     *
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
int chercheLettreRoue(char Tab[N][L], int WhN, char looking);
int tourneRoue(char Tab[N][L], int roue);

int main(int argc, char const *argv[]) // Fonction principale
{
    char Tab[N][L];

    LitCylindre(Tab);
    AfficheCylindre(Tab);
    //chercheLettreRoue(Tab, 0, 'g');
    tourneRoue(Tab,0);
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
    printf("\n");
    return EXIT_SUCCESS;
}

int chercheLettreRoue(char Tab[N][L], int WhN, char looking) // recherche d'une lettre spécifique dans une roue donnée
{
    for (int j = 0; j < L; j++)
    {
        if (Tab[WhN][j] == looking)
        {
            //printf("\nDans la roue %d, j'ai trouvé le caratère %c à l'indice %d\n",WhN, looking, j);
            return j;
        }
    }
    return EXIT_FAILURE;
}

int tourneRoue(char Tab[N][L],int roue) // Décalage de 1 vers le haut d'une roue, appelé cette fonction plusieurs fois pour des décalages succéssifs
{
    char TempT[L];

    for(int i = 0; i < L; i++)
        TempT[i] = Tab[roue][i];

    for(int i = 0; i < L - 1; i++)
        Tab[roue][i] = TempT[i+1];

    Tab[roue][L-1] = TempT[0];

    return EXIT_SUCCESS;
}