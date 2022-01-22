import java.util.*;

public class JeuDeCarte {

    private ArrayList<Carte> jeuComplet;

    // Ordre caractères unicode : Coeur, Pique, Carreau, Trèfle
    public static final char[] couleur = {'\u2665', '\u2660', '\u2666',
                                          '\u2663'};

    public static final String[] nom = {"Deux", "Trois", "Quatre", "Cinq",
                                        "Six", "Sept", "Huit", "Neuf", "Dix",
                                        "Valet", "Dame", "Roi", "As"};

    // Construction du jeu de cartes                                    
    public JeuDeCarte() 
    {
        jeuComplet = new ArrayList<Carte>();

        int k = 0;

        for (int i = 0; i < couleur.length; i++) 
        {
            for (int j = 0; j < nom.length; j++) 
            {
                Carte c = new Carte(k); // Valeur symbolique
                c.attribuer_couleur(couleur[i]);
                c.attribuer_nom(nom[j]);
                jeuComplet.add(c);
                k++;
            }
        }
        // On melange le jeu de cartes
        Collections.shuffle(jeuComplet);
    }

    public void afficherJeuDeCartes()
    {
        for (Carte i : jeuComplet) 
        {
            System.out.println(i);
        }
    }

    public Carte distribuerCarte()
    {
        return jeuComplet.remove(0);
    }

    public static void main(String[] args) 
    {
        JeuDeCarte Deck = new JeuDeCarte();
        Deck.afficherJeuDeCartes();
        // Carte tempCarte;
        System.out.println("---------------------");
        // Test distribution de cartes
        // for (int i = 0; i < 26; i++) 
        // {
        //     tempCarte = Deck.distribuerCarte();
        //     tempCarte.afficherCarte();
        // }
    }
}
