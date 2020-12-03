/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/strlen.c         *
*                    Creation Date: October 30, 2020 02:29 PM                    *
*                    Last Updated: October 30, 2020 02:29 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Strlen remake                                  *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define MAX_LENGTH 100

int stringlen(char* str);

int main(int argc, char const *argv[])
{
    char p[MAX_LENGTH]; 

    printf("Donnez moi une chaine de caratère que je trouve sa taille :");
    scanf("%s", p);
    printf("Taille de la chaine de caratère %d\n",stringlen(p));

    return 0;
}

int stringlen(char* str)
{
    int i = 0;

    while (*(str++)) // On parcours chaque élément du tableau jusqu'a la fin (!= '\0')
        i++;

    return i;
}