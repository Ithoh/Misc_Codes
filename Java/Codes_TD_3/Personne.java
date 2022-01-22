public class Personne {

    private String nom;
    private String prenom;

    Personne(String nom, String prenom) throws Identite_incomplete{

        if (nom == "" || prenom == "") {
            throw new Identite_incomplete(nom, prenom);
        }

        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Prenom : " + prenom;
    }

    public static void main(String[] args) {
    
        try {

            Personne p = new Personne("bob","");
            System.out.println(p);

        } catch (Exception e) {
            System.out.println("Main catch : " + e);
        }
    }

}

class Identite_incomplete extends Exception {

    private String nom;
    private String prenom;

    Identite_incomplete(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Identite incomplète !\nNom : " + nom + ", Prenom : " + prenom;
    }

}

