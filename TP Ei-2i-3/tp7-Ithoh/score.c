/*********************************************************************************
*                              Author: Author Name                               *
*         File Name: /home/leo/Documents/Info_Annee_3/tp7-Ithoh/score.c          *
*                    Creation Date: December 2, 2020 12:40 PM                    *
*                    Last Updated: December 2, 2020 12:40 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                              Needleman et Wunsch                               *
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "score.h"

/* Find the highest value in one dimensional array */
int max_tab(int size_tab, int* tab)
{
    int max = 0;
    for (int i = 0; i < size_tab; ++i)
    {
        if (tab[i] > max)
            max = tab[i];
        
    }

  return max;  
}

/* return maximum between 3 values */
int maximum(int a, int b, int c)
{
    int result;

    if (a > b && a > c)
        result = a;
    
    else if (b > c)
        result = b;
    
   else
        result = c;

    return result;
}

/* return minimum value between 2 values */
int minimum(int a, int b)
{
    int minimum;

    if (a > b)
        minimum = b;
    else
        minimum = a;

    return minimum;
}

/* Compare the ADN of two people, you need to input two ADN sequences */
int compare_adn(char* s1, char* s2)
{
    int cout = 0;
    int l1 = strlen(s1) + 1;
    int l2 = strlen(s2) + 1;
    int *d;

    if ((d = malloc(sizeof(int)* l1 * l2)) == NULL)
        exit(1);
    
    for (int i = 0; i < l1; i++)
        d[i * l2] = 0;

    for (int j = 0; j < l2; j++)
        d[j] = 0;
    

    for (int i = 1; i < l1; i++)
    {
        for (int j = 1; j < l2; j++)
        {
            if (s1[i-1] == s2[j-1])
                cout=1;
            else
                cout=-1;
            
            d[i*l2 + j] = maximum(d[(i - 1) * l2 + j] - 1,
                                  d[i * l2 + j - 1] - 1,
                                  d[(i - 1) * l2 + j - 1] + cout);
        }
    }
    cout = max_tab(l1*l2, d);
    free(d);
    return cout;
}

/* score of a compare and shortest string lenght*/
float similarity(int score, int shortest)
{
    float result = (float)score / (float)shortest;
    return result;
}