import java.util.*;

public class Personne {
    
    String nom;
    int age;

    Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    Personne(Scanner scanner) {

        System.out.print("Entrez un nom : ");
        String n = scanner.nextLine();
        this.nom = n;

        System.out.print("Entrez un age : ");
        int a = scanner.nextInt();
        this.age = a;
    }

    public String toString() {
        return "Nom : " + nom + "\nAge : " + age;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Personne p1 = new Personne("Jean", 45);
        Personne p2 = new Personne(scanner);

        System.out.println(p1);
        System.out.println(p2);

        scanner.close();

    }

}
