public class Carte {
    
    private int valeurSymbolique;
    private char couleur;
    private String nom = "";

    // Contructeur de la classe carte
    public Carte(int valeurSymbolique)
    {
        this.valeurSymbolique = valeurSymbolique;
    }

    public int donnerValeurSymbolique()
    {
        return valeurSymbolique;
    }

    public void attribuer_couleur(char couleur)
    {
        this.couleur = couleur;
    }

    public void attribuer_nom(String nom)
    {
        this.nom = nom;
    }

    public String toString()
    {
        return couleur + " " + nom;
    }

    public static void main(String[] args) 
    {

        // Carte car = new Carte(0);
        // car.attribuer_couleur("Coeur");
        // car.attribuer_nom("Deux");
        // car.afficherCarte();
        // System.out.println(car.donnerValeurSymbolique());

    }
}
