import java.util.Scanner;

public class Exercice1 {

    // Fonction pour calculer une puissance d'un nombre
    static double MyPow(double nbr, int puis){
        double result = 1;

        for(int i = 0; i < puis; i++)
        {
            result = result * nbr;
        }

        return (result);
    }

    // Fonction pour caluler le factorielle
    static int MyFact(int nbr){

        int result = 1;

        if (nbr > 12) 
        {
            nbr = 12;    
        }

        for (int i = 1; i <= nbr; i++) {
            result = result * i;
        }

        return result;
    }

    // Fonction pour calculer l'exponentielle
    static double MyExp(int nbr, int precision){

        double result = 0.0;

        for (int i = 0; i < precision; i++){
            result = result + (MyPow(nbr, i)/MyFact(i));
        }

        return result;
    }

    public static void main(String[] args){

        Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez un indice pour calculer l'exponentielle :");
        int expo = clavier.nextInt();
        System.out.print("Choississez une precision :");
        int prec = clavier.nextInt();

        System.out.println("Le resultat est : " + MyExp(expo,prec));

        clavier.close();
    }
}
