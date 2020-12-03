/*********************************************************************************
*                               Author: Léo Delas                                *
*          File Name: /home/leo/Documents/Langage_C/tp1-Ithoh/puiss1.c           *
*                   Creation Date: September 17, 2020 03:59 PM                   *
*                   Last Updated: September 17, 2020 08:37 PM                    *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp1-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int puissance(int,int);

int main(int argc, char const *argv[])
{
    int a,b;

    printf("Donnez moi un nombre :");
    scanf("%d",&a);
    printf("Donnez moi une puissance :");
    scanf("%d",&b);
    
    puissance(a,b);
}

int puissance(int x, int k)
{
    int i;
    int temp;
    i = 0;

    temp = x;

    while (++i < k)
    {
        temp = temp * x;
    }
    
    return printf("%d\n", temp);
}