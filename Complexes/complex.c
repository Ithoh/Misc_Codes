/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/complex.c        *
*                    Creation Date: November 4, 2020 04:37 PM                    *
*                    Last Updated: November 4, 2020 05:34 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                              Fonctions complexes                               *
*********************************************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "complex.h"

/*----------------------------------------------------------------
            Afficher un nombre complexe de type t_complex
----------------------------------------------------------------*/
void disp_complex(t_complex nbr) // 
{
    printf("%0.2f + %0.2fi\n",nbr.reel,nbr.im);
}

/*----------------------------------------------------------------
        Calcule le module d'un complexe de type t_complex
----------------------------------------------------------------*/
void module_complex(t_complex nbr)
{
    float module;

    module = sqrtf(nbr.reel * nbr.reel + nbr.im * nbr.im);

    printf("Voici le module : %f\n", module);
}


/*----------------------------------------------------------------
        additionne deux complexe de type t_complex
----------------------------------------------------------------*/
t_complex add_complex(t_complex nbr1, t_complex nbr2)
{
    t_complex result;

    result.reel = nbr1.reel + nbr2.reel;
    result.im = nbr1.im + nbr2.im;

    return result;
}

/*----------------------------------------------------------------
        multiplie deux complexe de type t_complex
----------------------------------------------------------------*/
t_complex multiply_complex(t_complex nbr1, t_complex nbr2)
{
    t_complex result;

    result.reel = nbr1.reel * nbr2.reel;
    result.im = nbr1.im * nbr2.im;

    return result;
}