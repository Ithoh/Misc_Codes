/**
 * Classe joueur contenant les infos du joueurs, son pseudo et sa couleur
 * @author L\u00E9o Delas
 * @see Case
 * @see Couleur
 * @see Ataxx
 * @see Plateau
 * @see Point
 */
public class Joueur {

    /** Entier ayant pour valeur 1, permet de definir la couleur du joueur */
    public static final int ROUGE = 1;
    /** Entier ayant pour valeur 2, permet de definir la couleur du joueur */
    public static final int BLEU = 2;
    String pseudo;
    int couleur;
    int nbrPions;

    /**
     * @param pseudo Pseudo du joueur à créer (Chaine de caractères)
     * @param couleur Couleur du joueur (ROUGE ou BLEU)
     */
    Joueur(String pseudo, int couleur) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.nbrPions = 2;
    }

    /** 
     * Fonction d'affichage d'un joueur, affiche son pseudo avec comme couleur
     * de fond sa couleur
    */
    public String toString() {
        String c;

        switch (couleur) {
            case ROUGE:
                c = Couleur.ROUGE_BCK + "[" + pseudo + "]" + Couleur.NORMALE_BCK;
                break;
            case BLEU:
                c = Couleur.BLEU_BCK + "[" + pseudo + "]" + Couleur.NORMALE_BCK;
                break;
            default:
                c = Couleur.NORMALE_BCK + "[Blanc]" + Couleur.NORMALE_BCK;
                break;
        }
            
        return c;
    }
}