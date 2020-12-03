/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/mainP2.c         *
*                    Creation Date: December 3, 2020 10:10 AM                    *
*                    Last Updated: December 3, 2020 10:10 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                     mainP2                                     *
*********************************************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "score.h"

int main(int argc, char const *argv[])
{
    char* string_1;
    char* string_2;

    printf("Séquence 1 : ");
    scanf("%ms", &string_1);
    printf("Séquence 2 : ");
    scanf("%ms", &string_2);

    int result_compare = compare_adn(string_1, string_2);
    int shortest_str = minimum(strlen(string_1), strlen(string_2));
    float same = similarity(result_compare, shortest_str);
    printf("Similarity : %.2f%%\n", same*100);

    free(string_1);
    free(string_2);

    return 0;
}