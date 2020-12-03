/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/strcmp.c         *
*                    Creation Date: December 2, 2020 08:39 AM                    *
*                    Last Updated: December 2, 2020 08:39 AM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/tp7-Ithoh.git                *
*                                                                                *
*                            --- Code Description ---                            *
*                            String compare function                             *
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "strcmp.h"


int main(int argc, char const *argv[])
{
    char* string_1;
    char* string_2;

    printf("Saissez une chaine de caractère : ");
    scanf("%ms", &string_1);
    printf("Saissez une chaine de caractère : ");
    scanf("%ms", &string_2);

    printf("%d\n",string_compare_1(string_1, string_2));
    printf("%d\n",strcmp(string_1, string_2));
    printf("%d\n",string_compare_2(string_1, string_2));

    free(string_1);
    free(string_2);

    return EXIT_SUCCESS;
}


int string_compare_1(char* s1, char* s2) // avec []
{
    int largest = 0;
    int diff = 0; // Pour compter les différences
    int end = 0; // Flag servant a dire que la comparaison est finie
    int i = 0;

    while (!end)
    {
        if (s1[i] == '\0' || s2[i] == '\0')
        {
            end = 1;
            if (diff == 0)
                largest = 0;
            
        }

        else if (s1[i] == s2[i])
        {
            i++;
            continue;
        }

        else if (s1[i] != s2[i])
        {
            diff++;

            if (diff == 1)
            {
                if (s1[i] - s2[i] < 0) // S2 est plus grand
                    largest = s1[i] - s2[i];
                else if (s1[i] - s2[i] > 0) // S1 est plus grand
                    largest = s1[i] - s2[i];
            }
        }
        i++;
    }
    return largest;
}

int string_compare_2(char* s1, char* s2) // avec des pointeurs que l'on incrémente
{
    int largest = 0;
    int diff = 0; // Pour compter les différences

    while (*(s1) || *(s2))
    {

        if (*(s1) == *(s2))
        {
            *(s1++);
            *(s2++);
            continue;
        }
        else if (*(s1) != *(s2))
        {
            diff++;

            if (diff == 1)
            {
                if (*(s1) - *(s2) < 0)
                    largest = *(s1) - *(s2);
                else if (*(s1) - *(s2) > 0)
                    largest = *(s1) - *(s2);
            }
        }
        *(s1++);
        *(s2++);
        
    }
    return largest;
}