/*********************************************************************************
*                               Author: Léo Delas                                *
*         File Name: /home/leo/Documents/Info_annee_3/tp3-Ithoh/bulles.c         *
*                    Creation Date: October 15, 2020 03:19 PM                    *
*                    Last Updated: October 15, 2020 03:54 PM                     *
*                               Source Language: c                               *
*        Repository: https://github.com/PolytechSorbonne-C/tp3-Ithoh.git         *
*                                                                                *
*                            --- Code Description ---                            *
*                Remplissage et tri d'un tableau (tri à bulles)                  *
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

int remplissage_tab(float T[100]) // Fonction qui ouvre un fichier.txt et lit son contenue pour le stocker dans un tableau
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

int tri_tableau(float T[100]) // Tri à bulles du tableau T
{   
    int nbr_element = 0;
    float temp = 0;

    FILE * valeurs = NULL;
    valeurs = fopen("valeurs.txt", "r"); // ouverture du fichier valeurs.txt pour récupérer le nombre d'élements
    if (valeurs != NULL) fscanf(valeurs, "%d", &nbr_element);

       for (int i = 0; i < nbr_element-1; i++) // Algorithme de tri à bulles du tableau
        {
            for (int j = 0; j < nbr_element-i-1; j++)
            {
                if (T[j] > T[j+1])
                {
                    temp = T[j];
                    T[j] = T[j+1];
                    T[j+1] = temp;
                }         
            }
        }
    save_tableau(T, nbr_element);
    return EXIT_SUCCESS;
}

int save_tableau(float T[100], int n) // Sauvegarde du tableau T trié dans un autre fichier.txt
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