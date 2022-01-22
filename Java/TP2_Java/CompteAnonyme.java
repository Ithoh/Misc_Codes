public class CompteAnonyme extends ComptePersonne{
    
    /** 
     *  Objet permettant de créer un compte anonyme, un compte anonyme
     *  n'affichera pas le nom et le prénom du propriétaire
     * 
     *  @param depotInitial Valeur initial déposé sur le compte personne
     *  @param nom Nom de la personne ouvrant le compte
     *  @param prenom Prenom de la personne ouvrant le compte
     * 
    */

    CompteAnonyme(double depotInitial, String nom, String prenom){
        super(depotInitial, nom, prenom);
    }

    public String toString() {
        
        return "Compte Anonyme\n" + "Numéro de compte : " + getNumeroDeCompte() + " | Solde : " + 
        getSolde() + " | Découvert : " + getDecouvert() + "\n";
    }
}