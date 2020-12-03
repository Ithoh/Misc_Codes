/*********************************************************************************
*                               Author: Léo Delas                                *
*           File Name: /home/leo/Documents/Langage_C/tp1-Ithoh/hexa.c            *
*                   Creation Date: September 17, 2020 08:36 PM                   *
*                   Last Updated: September 17, 2020 08:37 PM                    *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp1-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int hex_to_decimal();

int main(int argc, char const *argv[])
{
    hex_to_decimal();
}

int hex_to_decimal()
{
    char valeur_hexa;
    int result;
    result = 0;

    printf("Donnez moi un nombre en hexa : ");
    scanf("%c", &valeur_hexa);
    while ((valeur_hexa >= '0' && valeur_hexa <= '9') || (valeur_hexa >= 'A' && valeur_hexa <= 'F') || (valeur_hexa >= 'a' && valeur_hexa <= 'f'))
    {
        if (valeur_hexa >= 'A' && valeur_hexa <= 'F')
        result = (result * 16) + valeur_hexa - 'A' + 10;

        else if (valeur_hexa >= 'a' && valeur_hexa <= 'f')
        result = (result * 16) + valeur_hexa - 'a' + 10;

        else
        result = (result * 16) + valeur_hexa - '9' + 9;

        scanf("%c",&valeur_hexa);
    }

    return printf("Le nombre en base 10 est %d\n", result);
}