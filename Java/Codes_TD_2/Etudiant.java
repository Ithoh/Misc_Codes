public class Etudiant extends Scolaire{
    
    String formation;

    Etudiant(String nom, int age, String nomEtablissement, String niveau, String formation){

        super(nom,age,nomEtablissement,niveau);
        this.formation = formation;

    }

    public String toString() {
        return super.toString() + "\nFormation : " + formation;
    }

    public static void main(String[] args) {

        Etudiant e1 = new Etudiant("Bob", 19, "Polytech", "Master 1", "Ei2i");
        System.out.println(e1);
    }

}
