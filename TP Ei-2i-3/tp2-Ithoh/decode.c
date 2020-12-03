/*********************************************************************************
*                               Author: Léo Delas                                *
*         File Name: /home/leo/Documents/Info_annee_3/tp2-Ithoh/decode.c         *
*                    Creation Date: October 1, 2020 02:00 PM                     *
*                     Last Updated: October 1, 2020 05:22 PM                     *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp2-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int lecture();

int main(int argc, char const *argv[])
{

    lecture();
    return 0;
}

int lecture()
{
    int n; // integer input
    char c; // character input

    n = 0;
    c = '\0';

    while (n != -1) // loop until you get a negative number
    {
        scanf("%d %c", &n, &c);

        if (n == 0) // if interger is equal 0 then return
        {
            printf("\n");
        }
        
        else
        {
            for (int i = 0; i < n; i++)
            {
                printf("%c", c);
            }
        }
    }
    printf("#");

    return EXIT_SUCCESS;
}