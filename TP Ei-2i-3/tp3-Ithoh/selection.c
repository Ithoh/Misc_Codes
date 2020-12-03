/*********************************************************************************
*                               Author: Léo Delas                                *
*       File Name: /home/leo/Documents/Info_annee_3/tp3-Ithoh/selection.c        *
*                    Creation Date: October 15, 2020 01:51 PM                    *
*                    Last Updated: October 15, 2020 03:20 PM                     *
*                               Source Language: c                               *
*        Repository: https://github.com/PolytechSorbonne-C/tp3-Ithoh.git         *
*                                                                                *
*                            --- Code Description ---                            *
*                 Remplissage et tri d'un tableau (tri par sélection)            *
*********************************************************************************/


#include <stdio.h>
#include <stdlib.h>

int remplissage_tab(float T[100]); // prototype de fonction
int tri_tableau(float T[100]); // prototype de fonction
int save_tableau(float T[100], int n); // prototype de fonction

int main(int argc, char const *argv[])
{
    float T[100];
    remplissage_tab(T);
    tri_tableau(T);

    return EXIT_SUCCESS;
}
int remplissage_tab(float T[100]) // Fonction qui créer un tableau de taille variable en fonction de la première valeur du fichier valeurs.txt et qui lit ce fichier pour remplir le tableau
{
    int nbr_element = 0;
    float temp;
    FILE * valeurs = NULL;
    valeurs = fopen("valeurs.txt", "r"); // ouverture du fichier valeurs.txt

    if (valeurs != NULL)
    {
        fscanf(valeurs, "%d", &nbr_element);
        for (int i = 0; i < nbr_element; i++) // Boucle de lecture du fichier
        {
            fscanf(valeurs, "%f", &T[i]); // Lecture et remplissage du tableau
        }
    fclose(valeurs);
    }
    return EXIT_SUCCESS;
}

int tri_tableau(float T[100])
{   
    int nbr_element = 0;
    float temp = 0;

    FILE * valeurs = NULL;
    valeurs = fopen("valeurs.txt", "r"); // ouverture du fichier valeurs.txt pour récupérer le nombre d'élements
    if (valeurs != NULL) fscanf(valeurs, "%d", &nbr_element);

    for (int i = 0; i < nbr_element; i++) // Algorithme de tri par selection du tableau
    {
        for (int j = 0; j < nbr_element; j++)
        {
            if (T[i] > T[j]) // En changeant la comparaison (change de signe) on tri de manière croissante ou décroissante
                continue;
            else
            {
                temp = T[i];
                T[i] = T[j];
                T[j] = temp;
            }                 
        }
    }
    save_tableau(T, nbr_element);
    return EXIT_SUCCESS;
}

int save_tableau(float T[100], int n)
{
    FILE * valeurs_triees = NULL;
    valeurs_triees = fopen("valeurs_triees.txt", "w");

    for (int i = 0; i < n; i++)
    {
        fprintf(valeurs_triees, "%f\n", T[i]);
    }
    
    fclose(valeurs_triees);
    return EXIT_SUCCESS;
}
/*
variable temporaire

Boucle for 1 (variable i = 0)

    Boucle for 2 (variable j = 0)

    si T[j] > T[i]
        ne rien faire
    else
        temp = T[i]
        T[i] = T[j]
        T[j] = temp        
*/