/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/strcopy.c        *
*                    Creation Date: October 30, 2020 03:00 PM                    *
*                    Last Updated: October 30, 2020 03:00 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Strcopy remake                                 *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

#define MAX_LENGTH 100

void strcopy(char* dest, char* src);

int main(int argc, char const *argv[])
{
    char init[MAX_LENGTH];
    char final[MAX_LENGTH];

    printf("Donnez moi une chaine de caratère à copier :");
    scanf("%s", init);

    strcopy(final, init);
    printf("%s\n", final);
    
    return 0;
}

void strcopy(char* dest, char* src)
{
    while(*(src))
        *(dest++) = *(src++);
    *dest = 0;
}