/*********************************************************************************
*                               Author: Léo Delas                                *
*            File Name: /home/leo/Documents/Langage_C/tp1-Ithoh/pi.c             *
*                   Creation Date: September 17, 2020 03:07 PM                   *
*                   Last Updated: September 17, 2020 08:38 PM                    *
*                              Source Language: cpp                              *
*          Repository: https://github.com/PolytechSorbonne-C/tp1-Ithoh           *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define Precision 1000 // On utilise cette macro pour changer le nombre de test de points dans le cercle

int incircle();

int main(int argc, char const *argv[])
{
    incircle();
}

// Equation de cercle (x - a)² + (y - b)² = r²
// x et y distance par rapport au centre
// on a doit donc verifier l'équation suivante a² + b² = r²

int incircle()
{
    int r;
    int p;
    int i;
    float x, y;

    r = 1;
    i = 0;
    p = 0;

    srand(time(NULL));
    while (++i < Precision)
    {
        x = (float)rand()/(RAND_MAX/2) - 1;
        y = (float)rand()/(RAND_MAX/2) - 1;

        printf("x: %f y: %f\n", x, y);

        if (((x * x) + (y * y)) < (r * r))
        {
            p += 1;
        }
    }

    printf("Nombre de points dans le cercle %d:\n", p);
    printf("Approximation de pi : %f\n", (float)p/Precision*4);

    return 0;
}