import java.util.*;

public class Banque {

    String nomBanque;
    ArrayList<Compte> ComptesClients;

    Banque(String nomBanque) {
        this.nomBanque = nomBanque;
        ComptesClients = new ArrayList<Compte>();
    }

    void modifierDecouvert(ComptePersonne p, double nouveauDecouvert) {
        p.setDecouvert(nouveauDecouvert);
    }

    void ajouterCompte(Compte nouveauCompte) {
        ComptesClients.add(nouveauCompte);
    }

    Compte rechercherCompte(int numeroDeCompte) {

        for (Compte i : ComptesClients) {

            if (i.getNumeroDeCompte() == numeroDeCompte) {
                return i;
            }

        }

        return null;
    }

    void supprimerCompte(int numeroDeCompte) {

        for (Compte i : ComptesClients) {

            if (i.getNumeroDeCompte() == numeroDeCompte) {
                ComptesClients.remove(i);
            }
        }
    }

    Compte iemeCompte(int i) {
        return ComptesClients.get(i);
    }

    int numeroDuIemeCompte(int i) {
        return ComptesClients.get(i).getNumeroDeCompte();
    }

    int nombreDeCompte() {
        return ComptesClients.size();
    }

    void afficherBanque() {
        System.out.println("Nom de la banque : " + nomBanque + "\nNombre de client : " + nombreDeCompte() + "\n");
    }

    void afficherListeCompte() {
        for (Compte i : ComptesClients) {
            System.out.println(i);
        }
    }

    /**
     * Afficher tout les comptes d'un certain type
     * @param typeDeCompte Valeur possibles : "ComptePersonne", 
     * "CompteAnonyme", "CompteEntreprise"
     */

    void afficherListeCompte(String typeDeCompte) {

        for (Compte i : ComptesClients) {
            if (i.getClass().getName() == typeDeCompte) {
                System.out.println(i);
            }
        }
    }

    public String toString() {
        afficherBanque();
        afficherListeCompte();
        return "";
    }

    void triParSelection(){

        for (int i = 0; i < ComptesClients.size() - 1; i++) {
            int min = i;
                for (int j = i+1; j < ComptesClients.size(); j++) {
                    if (ComptesClients.get(j).getSolde() < ComptesClients.get(min).getSolde()) {
                        min = j;
                    }
                }
            if (min != i) {
                Collections.swap(ComptesClients, i, min);
            }    
        }

    }

    public static void main(String[] args) {
        
        Banque b1 = new Banque("Harvest & Trustee Bank");

        Random rand = new Random();
        Random depot = new Random();

        // Génère aléatoirement 101 comptes
        for (int i = 0; i < 101; i++) {
            
            switch (rand.nextInt(3)) {
                // Compte Personne
                case 0:
                    ComptePersonne cp = new ComptePersonne(depot.nextInt(1000), "Personne" , "Louis " + i);
                    b1.ajouterCompte(cp);
                    break;

                // Compte Anonyme
                case 1:
                    CompteAnonyme ca = new CompteAnonyme(depot.nextInt(1000), "Anonyme", "Louis " + i);
                    b1.ajouterCompte(ca);
                    break;

                // Compte CompteEntreprise
                case 2:
                    CompteEntreprise ce = new CompteEntreprise(depot.nextInt(1000), "Entreprise Louis " + i);
                    b1.ajouterCompte(ce);
                    break;

                default:
                    break;
            }
        }

        System.out.println(b1);

        b1.triParSelection();

        System.out.println(b1);
    
    }
}
