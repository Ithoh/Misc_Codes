public class Compte {
 
    private static int numero = 0;
    private int numeroDeCompte;
    private double solde;
    private double decouvert;

    /**
     * Object primaire compte, possédant plusieurs dérivés pouvant être créé
     * @param depotInitial Valeur initiale à déposer
     */


    Compte(double depotInitial){
        numeroDeCompte = numero;
        numero++;
        solde = depotInitial;
    }

    public void debiter(double montant){

        solde = solde - montant;
    }

    public void crediter(double montant){
        solde = solde + montant;
    }

    public boolean peutDebiter(double montant){

        if ((solde - montant) < decouvert) {
            System.out.println("Impossible de débiter, vous allez dépasser votre découvert");
            return false;
        }
        else {
            return true;
        }
    }

    public void virement(int numeroDeCompte, Banque bq, double montant){
        
        int index = -1;

        for (int i = 0; i < bq.ComptesClients.size(); i++) {
            if (bq.ComptesClients.get(i).getNumeroDeCompte() == numeroDeCompte) {
                index = i;
            }
        }

        if (index != -1) {

            if (peutDebiter(montant)){

                debiter(montant);
                bq.ComptesClients.get(index).crediter(montant);

            }    
        }
    }
    
    public void setDecouvert(double nouveauDecouvert){
        decouvert = -nouveauDecouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public int getNumeroDeCompte(){
        return numeroDeCompte;
    }

    public double getSolde(){
        return solde;
    }

    public String toString() {
        return "Numéro de compte : " + getNumeroDeCompte() + " | Solde : " + 
        getSolde() + " | Découvert : " + getDecouvert() + "\n";
    }

}
