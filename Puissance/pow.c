/*********************************************************************************
*                              Author: Author Name                               *
*           File Name: /home/leo/Language_C/pow_recurse/pow_recurse.c            *
*                    Creation Date: October 16, 2020 02:08 PM                    *
*                    Last Updated: October 16, 2020 02:08 PM                     *
*                               Source Language: c                               *
*        Repository: https://github.com/PolytechSorbonne-C/tp3-Ithoh.git         *
*                                                                                *
*                            --- Code Description ---                            *
*                                  Recurse pow                                   *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>

double power(int,int);

int main(int argc, char const *argv[])
{
    int x, k;

    printf("Donnez moi un nombre a calculez a une puissance ");
    scanf("%d", &x);

    printf("Donnez moi une puissance pour ce nombre ");
    scanf("%d", &k);

    printf("Voici le nombre %d a la puissance %d = %lf\n",x,k,power(x,k));
}

double power(int x,int k)
{
    double res;

    if(k == 0)
        return 1;

    if (k % 2 == 0)
    {
        res = power(x,k/2);
        return(res*res);
    }

    if (k % 2 != 0)
    {
        res = power(x,k/2);
        return(res*res*x);
    }

    return EXIT_SUCCESS;
}
