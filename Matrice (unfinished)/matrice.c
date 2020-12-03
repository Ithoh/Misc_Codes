#include <stdio.h>
#include <stdlib.h>

int **mat_square_inf(int size)
{
    int **Tab = malloc(size * sizeof(int*));
    
    for (int i = 0; i < size; i++)
        Tab[i] = malloc((i+1) * sizeof(int));
    
    return Tab;
}

void dis_mat(int **tab, int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < i+1; j++)
        {
            printf("%d ", tab[i][j]);
        }
        printf("\n");   
    }
}

int main(int argc, char const *argv[])
{

    int size;
    int **Mat;

    scanf("%d", &size);

    Mat = mat_square_inf(size);
    dis_mat(Mat, size);

    return 0;
}

// void remplir(int** tab,int n){
//         int s=1;
//         for (int i=0;i<n;i++){
//                 tab[i][0]=1;
//                 tab[i][s-1]=1;
//                 for(int j=1;j<(s-1);j++){
//                         tab[i][j]=tab[i-1][j-1]+tab[i-1][j];
//                 }
//                 s++;
//         }
// }
