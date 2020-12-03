#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{

    char* first_name;
    char* last_name;
    unsigned int age;

}t_fiche;

void remplir_fiche(FILE* file, t_fiche* fiche)
{

    char prenom[50];
    char nom[50];

    fscanf(file, "%s %s %d", prenom, nom, &fiche->age);

    if ((fiche->first_name = malloc(strlen(nom) + 1)) == NULL)
        exit(EXIT_FAILURE);
    if ((fiche->last_name = malloc(strlen(nom) + 1)) == NULL)
        exit(EXIT_FAILURE);

    strcpy(fiche->first_name, prenom);
    strcpy(fiche->last_name, nom);
}

t_fiche *remplir_tab_fich(char *name, int *size)
{
    FILE *file;
    file = fopen(name, "r");

    if (!file) exit(EXIT_FAILURE);

    fscanf(file, "%d", size);

    t_fiche *Tab;
    Tab = malloc(sizeof(t_fiche) * (*size + 1));

    for (int i = 0; i < *size; i++)
        remplir_fiche(file, &Tab[i]);
    
    return Tab;
}

void free_fiches(t_fiche *fiche, int size)
{
    int i = -1;
    
    while (++i != size)
    {
        free(fiche[i].first_name);
        free(fiche[i].last_name);
        free(&fiche[i]);
    }
}

int disp_fiche(t_fiche *fiches, int size)
{
    int i = -1;

    while (++i != size)
    {
        printf("Prénom : %s\nNom : %s\nAge : %d\n", fiches[i].first_name, fiches[i].last_name, fiches[i].age);
    }
    return 0;
    
}

int main(int argc, char const *argv[])
{
    
    int size;

    t_fiche *Tab_Fiches = remplir_tab_fich("fiches.txt", &size);
    disp_fiche(Tab_Fiches, size);
    free(Tab_Fiches);

    return EXIT_SUCCESS;
}
