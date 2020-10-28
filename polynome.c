/*********************************************************************************
*                               Author: Léo Delas                                *
*       File Name: /home/leo/Documents/Info_annee_3/Misc_Codes/polynome.c        *
*                    Creation Date: October 28, 2020 05:18 PM                    *
*                    Last Updated: October 28, 2020 05:42 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                       Calcul des racines d'un polynomes                        *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float poly(float, float, float, float*, float*); // Prototype de fonction

int main(int argc, char const *argv[])
{
    float a,b ,c , r1, r2, result;

    printf("Valeur de a :");    // Scanf des valeurs a,b,c
    scanf("%f", &a);
    printf("Valeur de b :");
    scanf("%f", &b);
    printf("Valeur de c :");
    scanf("%f", &c);

    result = poly(a,b,c,&r1,&r2);

    if (result < 0)
        printf("Il n'y a pas de racines\n");
    
    else if (result == 0)
        printf("Il y a une racine %f\n", r1);

    else
        printf("Il y a 2 racines\nRacine 1 : %f\nRacine 2 : %f\n", r1 , r2);
}

float poly(float a, float b, float c, float* r1, float* r2)
{
    float det, racine1, racine2;
    det = (b*b) - 4*a*c;

    if (det < 0) // Si le determinant est inférieur à zéro
    {
        return -1;
    }
    else if (det == 0) // Si le determinant est égale à 0
    {
        racine1 = -(b/2*a); // Calcul des racines
        racine2 = racine1;
        *r1 = racine1;
        *r2 = racine2;
        return 0;
    }
    else // Determinant supérieur à 0
    {
        racine1 = (-b+sqrt(det))/2*a; // Calcul des racines
        racine2 = (-b-sqrt(det))/2*a;
        *r1 = racine1;
        *r2 = racine2;
        return 1;
    }
}