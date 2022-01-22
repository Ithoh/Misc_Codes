import java.util.*;

public class Paquet {

    private ArrayList<Carte> paquetDeCarte;
    private boolean estVide;

    public Paquet() 
    {
        paquetDeCarte = new ArrayList<Carte>();
        estVide = true;
    }

    // Distribution des 26 cartes
    public Paquet(JeuDeCarte UnJeuDeCarte) 
    {
        paquetDeCarte = new ArrayList<Carte>();

        for (int i = 0; i < 26; i++) 
        {
            paquetDeCarte.add(UnJeuDeCarte.distribuerCarte());
        }

        estVide = false;
    }

    public boolean estVide() 
    {
        estVide = paquetDeCarte.isEmpty();
        return estVide;
    }

    public Carte poserCarte() 
    {
        return paquetDeCarte.remove(0);
    }

    public Carte consulterPremiereCarte()
    {
        return paquetDeCarte.get(0);
    }

    public Carte consulterDerniereCarte()
    {
        return paquetDeCarte.get(paquetDeCarte.size()-1);
    }

    public void ajouterCarte(Carte c)
    {
        // Rajoute une carte à la fin du paquet
        paquetDeCarte.add(c);
    }

    public void ajouterPaquet(Paquet p)
    {
        for (int i = 0; i < p.paquetDeCarte.size(); i++) 
        {
            paquetDeCarte.add(p.paquetDeCarte.remove(0));
        }
    }

    public int donnerTaillePaquet() 
    {
        return paquetDeCarte.size();
    }

    public void afficherPaquet() 
    {
        for (Carte i : paquetDeCarte)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) 
    {
        JeuDeCarte jdc = new JeuDeCarte();
        Paquet joueur1 = new Paquet(jdc);
        Paquet joueur2 = new Paquet(jdc);

        joueur1.ajouterPaquet(joueur2);
        // Paquet joueur2 = new Paquet(jdc);
        // joueur1.afficherPaquet();
        // System.out.println("----------------");
        // joueur2.afficherPaquet();
        // System.out.println(joueur1.estVide());
        // System.out.println(joueur2.estVide());

        // System.out.println("----------------");
        // System.out.println(joueur1.consulterPremiereCarte());
        // System.out.println(joueur1.consulterDerniereCarte());

    }
}
