/*********************************************************************************
*                               Author: Léo Delas                                *
*          File Name: /home/leo/Documents/Info_annee_3/tp2-Ithoh/code.c          *
*                    Creation Date: October 1, 2020 03:00 PM                     *
*                     Last Updated: October 1, 2020 05:22 PM                     *
*                               Source Language: c                               *
*          Repository: https://github.com/PolytechSorbonne-C/tp2-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int code(); // Function to encode a file

int main(int argc, char const *argv[])
{

    code();

    return 0;
}

int code()
{
    int i;  // number of iterations of one character
    char c, ctemp; // c = current character / ctemp = previous character
    
    i = 0;
    c = '\0';
    ctemp = '\0';

    scanf("%c", &c);
    ctemp = c;

    while (c != '#' || ctemp != '#') // check for end of file
    {

        while (c - ctemp == 0)
        {
            scanf("%c", &c);
            i++;
        }
        
        printf("%d %c ", i, ctemp);

        if (c == '\n')
        {
            printf("%d %c\n", 0, 'M');
            i = 0;
        }
        
        i = 1;
        ctemp = c;

        scanf("%c", &c);

        if (ctemp == '\n')
        {
           ctemp = c;
           i = 0;
        }

        if (ctemp == '#' && c == '#')
            printf("%d %c \n", -1, 'M');
    }
    return EXIT_SUCCESS;
}