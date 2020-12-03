/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/strcat.c         *
*                    Creation Date: October 30, 2020 03:16 PM                    *
*                    Last Updated: October 30, 2020 03:16 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Strcat remake                                  *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define MAX_LENGTH 100

void stringcat(char* dest, char* src);

int main(int argc, char const *argv[])
{
    char init[MAX_LENGTH];
    char final[MAX_LENGTH] = "Hello";

    printf("Donnez moi une chaine de caratère à concatener :");
    scanf("%s", init);
    
    stringcat(final, init);
    printf("%s\n", final);

    return 0;
}

void stringcat(char* dest, char* src)
{
    while (*(dest)) dest++;

    while ((*(dest++) = *(src++)));
}