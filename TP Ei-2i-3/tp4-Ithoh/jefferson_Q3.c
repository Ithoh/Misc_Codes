/*********************************************************************************
*                               Author: Léo Delas                                *
*      File Name: /home/leo/Documents/Info_annee_3/tp4-Ithoh/jefferson_Q3.c      *
*                    Creation Date: October 29, 2020 04:55 PM                    *
*                    Last Updated: October 29, 2020 05:43 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*********************************************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define N 19 // Nombre de colonnes
#define L 26 // Nombre de lignes

int LitCylindre(char Tab[N][L]); // Prototypes de fonctions
int AfficheCylindre(char Tab[N][L]);
int chercheLettreRoue(char Tab[N][L], int WhN, char looking); // WhN Stands for wheel number
int tourneRoue(char Tab[N][L], int roue);
int saisi(char Tab[N][L]);
int move_wheels(char Tab[N][L]);

int main(int argc, char const *argv[]) // Fonction principale
{
    char Tab[N][L];

    /*  Ordre des roues     : "1 6 14 0 5 8 7 9 10 12 13 17 14 2 2 4 8 3 16" 
        Message à décoder   : "tmjxdhgogpyujjcqryh"

        NB : J'ai fais en sorte qu'il y est une "animation" au moment où les roues tournes (j'ai juste afficher
        chaque fois le cylindre plusieurs fois à la suite) aggrandissez un peu le terminal pour voir le cylindre en entier
    */

    LitCylindre(Tab);
    move_wheels(Tab);
    saisi(Tab); 

    return 0;
}

int LitCylindre(char Tab[N][L]) // Fonction qui rempli le tableau 
{
    FILE * grille = NULL;
    grille = fopen("./jefferson.txt", "r"); // on ouvre le fichier

    if (grille != NULL) // on verifie si le fichier n'est pas vide
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < L; j++)
                fscanf(grille, "%c", &Tab[i][j]); // on rempli le tableau
        }
    }
    fclose(grille); // on ferme le fichier
    return EXIT_SUCCESS;
}

int AfficheCylindre(char Tab[N][L]) // Affichage du cylindre de jefferson
{
    printf("\n");
    for (int i = 0; i < L; i++)
    {
        for (int j = 0; j < N; j++)
            printf("|%c", Tab[j][i]);

        printf("|\n");
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

int saisi(char Tab[N][L]) // fonction de saisi de message a décodé
{
    char temp;
    int decal;
    scanf("%c",&temp); // Scanf pour enlevé le retour chariot dans le buffer

    printf("Donnez moi une suite de 19 lettres :");
    for (int i = 0; i < N; i++)
    {
        scanf("%c", &temp);
        decal = chercheLettreRoue(Tab, i, temp);

        for (int j = 0; j < decal; j++)
        {
            tourneRoue(Tab, i);
            AfficheCylindre(Tab);
            usleep(25000); // Changer la valeur pour accélérer l'affichage
        }
    }

    return EXIT_SUCCESS;
}

int move_wheels(char Tab[N][L]) // Fonction permettant de changer l'ordre des roues
{
    int Temp[N];
    char T45[N][L];

    printf("Saisissez un ordre de roue (19 nombres séparé d'un espace) :");
    for (int i = 0; i < N; i++)
        scanf("%d", &Temp[i]);

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < L; j++)
        {
            T45[i][j] = Tab[i][j];
        }
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < L; j++)
        {
            Tab[i][j] = T45[Temp[i]][j];
        }
    }

    return EXIT_SUCCESS;
}