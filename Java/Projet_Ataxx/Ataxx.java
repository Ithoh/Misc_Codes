import static java.lang.System.out;

/**
 * Classe contenant le d\u00E9roulement de la partie du jeu Ataxx
 */
public class Ataxx {

    Joueur j1;
    Joueur j2;
    Joueur joueurCourant;
    Plateau board;

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