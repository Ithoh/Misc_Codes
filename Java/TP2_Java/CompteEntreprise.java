public class CompteEntreprise extends Compte{
    
    /** 
     *  Objet permettant de créer un compte entreprise
     * 
     *  @param depotInitial Valeur initial déposé sur le compte personne
     *  @param nomEntreprise Nom de l'entreprise ouvrant le compte
     * 
    */

    public String nomEntreprise;

    CompteEntreprise(double depotInitial, String nomEntreprise){
        super(depotInitial);
        this.nomEntreprise = nomEntreprise;
    }

    public String toString() {
        
        return "Compte Entreprise : " + nomEntreprise + "\n" + super.toString();
    }
}
