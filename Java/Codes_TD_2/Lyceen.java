public class Lyceen extends Etudiant{

    String filiere_bac;

    Lyceen(String nom, int age, String nomEtablissement, String niveau, String formation, String filiere_bac){

        super(nom, age, nomEtablissement, niveau, formation);
        this.filiere_bac = filiere_bac;

    }

    public String toString() {

        return super.toString() + "\nFilière bac = " + filiere_bac;
    }
    
}
