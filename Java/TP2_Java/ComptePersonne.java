public class ComptePersonne extends Compte{
    
    private String nom;
    private String prenom;


    /** 
     *  Objet permettant de créer un compte personne
     * 
     *  @param depot Valeur initial déposé sur le compte personne
     *  @param nom Nom de la personne ouvrant le compte
     *  @param prenom Prenom de la personne ouvrant le compte
     * 
    */

    ComptePersonne(double depot, String nom, String prenom){
        super(depot);
        this.nom = nom;
        this.prenom = prenom;
    }

    public void modifierDecouvert(double nouveauDecouvert){
        super.setDecouvert(nouveauDecouvert);
    }

    public String toString() {

        return "Compte Personne : "+ nom + " " + prenom + "\n" + super.toString();
    }
}
