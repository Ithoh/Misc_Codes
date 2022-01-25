import static java.lang.System.out;

/**
 * Classe contenant le d\u00E9roulement de la partie du jeu Ataxx
 * La partie contient deux joueurs ainsi qu'un plateau de jeu, pour lancer
 * le jeu il suffit d'exectuer la classe ataxx
 * @author L\u00E9o Delas
 * @see Case
 * @see Couleur
 * @see Joueur
 * @see Plateau
 * @see Point
 */
public class Ataxx {

    /** Premier joueur de la partie, est de couleur rouge */
    public Joueur j1;
    /** Deuxieme joueur de la partie, est de couleur bleu */
    public Joueur j2;
    /** Variable permettant de connaitre le joueur en cours lors de la 
     * partie
     */
    public Joueur joueurCourant;
    /** Plateau de jeu, pour plus de detail voir {@link Plateau} */
    public Plateau board;

    Ataxx(){
        // On cr\u00E9er le plateau de jeu
        board = new Plateau();
        
        out.println("Veuillez entrer un pseudo pour le joueur 1 (Rouge)");
        j1 = new Joueur(Plateau.clavier.nextLine(),Joueur.ROUGE);
        out.println("Veuillez entrer un pseudo pour le joueur 2 (Bleu)");
        j2 = new Joueur(Plateau.clavier.nextLine(),Joueur.BLEU);

        board.init_plateau();

        // On change le pointeur de joueur courant pour le faire pointer sur j1 
        // Car lors du début de la partie il s'agit du joueur rouge qui commence
        joueurCourant = j1;
    }

    /**
     * Seule methode de la classe ataxx, elle permet de lancer une partie de jeu
     * pour lancer une partie il vous suffit de creer un nouvel objet Ataxx, et
     * de lancer la partie dans le main, ou alors d'executer la classe Ataxx
     */
    public void lancerPartie(){

        while (true) {
            switch (joueurCourant.couleur) {

                case Joueur.ROUGE:
                    board.selectionerCase(j1, j2);
                    board.verifierVainqueur(j1, j2);
                    joueurCourant = j2;
                    break;
            
                case Joueur.BLEU:
                    board.selectionerCase(j2, j1);
                    board.verifierVainqueur(j1, j2);
                    joueurCourant = j1;
                    break;

                default:
                    break;
            }
        }

    }

    public static void main(String[] args) {
        Ataxx Partie = new Ataxx();
        Partie.lancerPartie();
    }
}