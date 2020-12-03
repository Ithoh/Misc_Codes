/*********************************************************************************
*                              Author: Author Name                               *
*          File Name: /home/leo/Documents/Info_Annee_3/tp6-Ithoh/main.c          *
*                    Creation Date: November 5, 2020 02:45 PM                    *
*                    Last Updated: November 5, 2020 02:46 PM                     *
*                               Source Language: c                               *
*              Repository: https://github.com/Ithoh/Misc_Codes.git               *
*                                                                                *
*                            --- Code Description ---                            *
*                                 Blackjack main                                 *
*********************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "carte.h"
#include "partie.h"

int main(int argc, char const *argv[])
{
    t_partie Partie1;
    char ans[3];

    char Nom1[20] = "Jacob";        // -> Nom du joueur
    char Nom2[20] = "Jean-Pierre";  // -> Nom de l'ordinateur
    
    init_partie(&Partie1, Nom1, Nom2);

    distrib_carte(&Partie1, 0); // ordinateur
    distrib_carte(&Partie1, 1); // joueur
    distrib_carte(&Partie1, 0); // ordinateur
    distrib_carte(&Partie1, 1); // joueur
    
    printf("Voici la main de l'ordinateur :");
    affich_main(&(Partie1.ordinateur));

    printf("Voici la main du joueur :");
    affich_main(&(Partie1.joueur));

    printf("%s voulez vous piocher une carte ? ",Partie1.joueur.Nom);
    scanf("%s",ans);

    if (strcmp(ans, "oui") == 0)
    {
        distrib_carte(&Partie1, 1); // joueur
        printf("Voici la main du joueur :");
        affich_main(&(Partie1.joueur));
    }

    while (strcmp(ans, "oui") == 0  && (calc_val_main(&(Partie1.joueur))) <= 21 && Partie1.posPioche <= 42)
    {
        if ((calc_val_main(&(Partie1.ordinateur))) <= 16)
        {
            printf("L'ordinateur tire une carte\n");
            distrib_carte(&Partie1, 0); // ordinateur
            printf("Voici la nouvelle main de l'ordinateur :");
            affich_main(&(Partie1.ordinateur));

            if ((calc_val_main(&(Partie1.ordinateur))) > 21)
            {
                printf("L'ordinateur à perdu !\n");
                printf("Voulez vous continuez à jouer ? ");
                scanf("%s", ans);

                if (strcmp(ans, "oui") == 0)
                {
                    empty_deck(&(Partie1.joueur.main));     // On vide la main du joueur
                    Partie1.joueur.nbCartes = 0;            // Le joueur 1 possède 0 cartes
                    empty_deck(&(Partie1.ordinateur.main)); // On vide la main de l'autre joueur
                    Partie1.ordinateur.nbCartes = 0;        // Le joueur 2 possède 0 cartes

                    distrib_carte(&Partie1, 0);             // ordinateur
                    distrib_carte(&Partie1, 1);             // joueur
                    distrib_carte(&Partie1, 0);             // ordinateur
                    distrib_carte(&Partie1, 1);             // joueur

                    printf("Voici la main de l'ordinateur :");
                    affich_main(&(Partie1.ordinateur));

                    printf("Voici la main du joueur :");
                    affich_main(&(Partie1.joueur));
                }
            }
        }

        if ((calc_val_main(&(Partie1.joueur))) <= 21)
        {
            printf("%s voulez vous piocher une nouvelle carte ? ", Partie1.joueur.Nom);
            scanf("%s", ans);

            if (strcmp(ans, "oui") == 0)
            {
                distrib_carte(&Partie1, 1); // joueur
                printf("Voici la main du joueur :");
                affich_main(&(Partie1.joueur));
            }

            if ((calc_val_main(&(Partie1.joueur))) > 21)
            {
                printf("Le joueur à perdu !\n");
                printf("Voulez vous continuez à jouer ? ");
                scanf("%s", ans);

                if (strcmp(ans, "oui") == 0)
                {
                    empty_deck(&(Partie1.joueur.main));     // On vide la main du joueur
                    Partie1.joueur.nbCartes = 0;            // Le joueur 1 possède 0 cartes
                    empty_deck(&(Partie1.ordinateur.main)); // On vide la main de l'autre joueur
                    Partie1.ordinateur.nbCartes = 0;        // Le joueur 2 possède 0 cartes

                    distrib_carte(&Partie1, 0);             // ordinateur
                    distrib_carte(&Partie1, 1);             // joueur
                    distrib_carte(&Partie1, 0);             // ordinateur
                    distrib_carte(&Partie1, 1);             // joueur

                    printf("Voici la main de l'ordinateur :");
                    affich_main(&(Partie1.ordinateur));

                    printf("Voici la main du joueur :");
                    affich_main(&(Partie1.joueur));
                } 
            }
        }
    }


    return EXIT_SUCCESS;
}