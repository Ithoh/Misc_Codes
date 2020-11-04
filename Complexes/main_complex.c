/*********************************************************************************
*                              Author: Author Name                               *
*     File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/main_complex.c      *
*                    Creation Date: November 4, 2020 04:44 PM                    *
*                    Last Updated: November 4, 2020 05:35 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Main complexe                                  *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "complex.h"

int main(int argc, char const *argv[])
{
    t_complex n1, n2, n3, result;

    n1.reel = 1; n1.im = 1;
    n2.reel = 3; n2.im = 0.5;
    n3.reel = 0; n3.im = 2;

    result = add_complex(multiply_complex(n1, n2), n3);

    disp_complex(result);
    module_complex(result);

    return 0;
}
