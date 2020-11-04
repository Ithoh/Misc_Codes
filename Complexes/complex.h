/*********************************************************************************
*                              Author: Author Name                               *
*        File Name: /home/leo/Documents/Info_Annee_3/Misc_Codes/complex.h        *
*                    Creation Date: November 4, 2020 04:39 PM                    *
*                    Last Updated: November 4, 2020 05:35 PM                     *
*                              Source Language: cpp                              *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                Complexe header                                 *
*********************************************************************************/

#ifndef __COMPLEX_H__
#define __COMPLEX_H__

typedef struct {

    float reel;
    float im;

}t_complex;

void disp_complex(t_complex nbr);
void module_complex(t_complex nbr);
t_complex add_complex(t_complex nbr1, t_complex nbr2);
t_complex multiply_complex(t_complex nbr1, t_complex nbr2);

#endif
