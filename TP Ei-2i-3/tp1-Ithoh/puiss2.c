/*********************************************************************************
*                               Author: Léo Delas                                *
*          File Name: /home/leo/Documents/Langage_C/tp1-Ithoh/puiss2.c           *
*                   Creation Date: September 17, 2020 07:39 PM                   *
*                   Last Updated: September 17, 2020 08:37 PM                    *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp1-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int puissance2(int,int);

int main(int argc, char const *argv[])
{
    int a,b;

    printf("Donnez moi un nombre :");
    scanf("%d",&a);
    printf("Donnez moi une puissance :");
    scanf("%d",&b);
    
    puissance2(a,b);
}

int puissance2(int x, int k)
{
    int resultat;
    int temp;

    resultat = x;
    temp = 1;

    while (k > 1)
    {
        if (k % 2 == 0)
        {    
            k = k / 2;
            resultat *= resultat;
        }

        else if (k % 2 != 0)
        {   
            k /= 2;
            temp = temp * resultat;
            resultat *= resultat;
        }
    }   
    return printf("Voici le resultat : %d\n", resultat*temp);
}