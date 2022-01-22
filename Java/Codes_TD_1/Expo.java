import java.util.Scanner;

public class Expo {
    public static void main(String args[]){
    
    int puissance;
    
    Scanner clavier = new Scanner(System.in);

    System.out.print("Entrez un entier pour calculer une puissance d'exponentielle : ");
    puissance = clavier.nextInt();

    double result = 0.0;
    result = Math.pow(Math.E, puissance);
    System.out.println("Le résultat de l'exponentielle à la puissance " + puissance + "vaut : " + result);

    clavier.close();
    
    }
}
