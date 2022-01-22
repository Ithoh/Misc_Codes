import java.util.*;

public class Scolaire extends Personne {

    String nomEtablissement;
    String niveau;

    Scolaire(String nom, int age, String ne, String niveau) {

        super(nom, age);
        this.nomEtablissement = ne;
        this.niveau = niveau;

    }

    Scolaire(Scanner scanner){

        super(scanner);

        System.out.println("Nom etablissement : ");
        String nomEtablissement = scanner.nextLine();

        System.out.println("Niveau : ");
        String niveau = scanner.nextLine();

        this.nomEtablissement = nomEtablissement;
        this.niveau = niveau;

    }

    public String toString() {
        return super.toString() + "\nNom Etablissement : " + nomEtablissement + "\nNiveau : " + niveau;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Scolaire scolaire1 = new Scolaire(scanner);
        
        System.out.println(scolaire1);

    }

}
