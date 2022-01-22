import java.util.Scanner;

public class Exercice2 {
    
    static int[] TrouverDiviseur(int nbr){

        int[] tabDiviseur = new int[317];
        int j = 0;
        double result = 0;

        // Cherche les diviseurs
        for(int i = 1; i < nbr; i++){

            result = nbr%i;

            if (result == 0){
                tabDiviseur[j] = i;
                j++;
            }
        }

        // Compte le nombre de diviseurs
        int compt = 0;
        
        for (int i : tabDiviseur) {
            if (i != 0) {
                compt++;
            }
        }

        // On créer un nouveau tableau de taille adéquate
        int[] finalDivseur = new int[compt];

        for (int i = 0; i < finalDivseur.length; i++){
            finalDivseur[i] = tabDiviseur[i];
        }

        return finalDivseur;
    }

    static void TrouverParfait(int max){

        for (int i = 1; i <= max; i++){

            // On cherche les diviseurs pour chaque itération
            int[] Diviseur = TrouverDiviseur(i);

            int sommeDiviseur = 0;

            // Calcule de la somme des diviseurs
            for (int j = 0; j < Diviseur.length; j++){
                sommeDiviseur += Diviseur[j]; 
            }

            // Si le nombre est parfait (Somme des diviseurs est égale à lui même)
            // on  affiche les diviseurs
            if (sommeDiviseur == i) {
                System.out.println("J'ai trouver : " + i);
                System.out.print("Ses diviseurs sont :");
                for (int div : Diviseur) {
                    System.out.print(" " + div);
                }
                System.out.println("");
            }
        }
    }

    static public void main(String[] args){

        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez un nombre maxmimum pour la rechercher des nombres parfaits : ");
        int nbr = clavier.nextInt();
        TrouverParfait(nbr);
        clavier.close();

    }
}
