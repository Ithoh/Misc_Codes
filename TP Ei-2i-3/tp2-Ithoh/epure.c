/*********************************************************************************
*                               Author: Léo Delas                                *
*         File Name: /home/leo/Documents/Info_annee_3/tp2-Ithoh/epure.c          *
*                    Creation Date: October 1, 2020 05:37 PM                     *
*                     Last Updated: October 1, 2020 05:37 PM                     *
*                              Source Language: cpp                              *
*          Repository: https://github.com/PolytechSorbonne-C/tp2-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int epure();

int main(int argc, char const *argv[])
{

    epure();

    return 0;
}

int epure()
{

    int SOL; // Start of line
    char c; // Current character

    SOL = 1;
    c = getc(stdin);

    while (c != EOF)
    {
        if (SOL == 1 && (c == '\n' || c == ' ' || c == '\t'))
        {}

        else if (c == '\n')
        {
            SOL = 1;
            printf("%c",c);
        }

        else
        {
            printf("%c",c);
            SOL = 0;
        }

        c = getc(stdin);
    }

    return EXIT_SUCCESS;
}
