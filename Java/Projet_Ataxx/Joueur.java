/**
 * Classe joueur contenant les infos du joueurs
 * 
 */
public class Joueur {

    public static final int ROUGE = 1;
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