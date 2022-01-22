import static java.lang.System.out;

import java.util.Scanner;

/**
 * Classe enuméré contenant les couleurs pour colorer le terminal
 */
enum Couleur {
    // FOR : foreground (couleur des caractères).
    // BCK : background (couleur du fond).
    BLEU_FOR, BLEU_BCK,
    ROUGE_FOR, ROUGE_BCK,
    VERT_FOR, VERT_BCK,
    JAUNE_FOR, JAUNE_BCK,
    MAGENTA_FOR, MAGENTA_BCK,
    GRIS_FOR, GRIS_BCK,
    NORMALE_FOR, NORMALE_BCK;

    /**
     * Utilisation : System.out.println(Couleur.COULEUR + "some text")
     */
    public String toString() {
        String affichage = "";

        switch (this) {
            case BLEU_FOR:
                affichage = "\u001B[94m";
                break;
            case BLEU_BCK:
                affichage = "\u001B[104m";
                break;
            case ROUGE_FOR:
                affichage = "\u001B[91m";
                break;
            case ROUGE_BCK:
                affichage = "\u001B[101m";
                break;
            case VERT_FOR:
                affichage = "\u001B[32m";
                break;
            case VERT_BCK:
                affichage = "\u001B[42m";
                break;
            case JAUNE_FOR:
                affichage = "\u001B[93m";
                break;
            case JAUNE_BCK:
                affichage = "\u001B[103m";
                break;
            case MAGENTA_FOR:
                affichage = "\u001B[95m";
                break;
            case MAGENTA_BCK:
                affichage = "\u001B[105m";
                break;
            case GRIS_FOR:
                affichage = "\u001B[37m";
                break;
            case GRIS_BCK:
                affichage = "\u001B[47m";
                break;
            case NORMALE_FOR:
                affichage = "\u001B[37m";
                break;
            case NORMALE_BCK:
                affichage = "\u001B[40m";
                break;
        }
        return affichage;
    }
}

/**
 * Classe joueur contenant les infos du joueurs
 * 
 */
class Joueur {

    public static final int ROUGE = 1;
    public static final int BLEU = 2;
    String pseudo;
    int couleur;
    Boolean peutJouer;

    /**
     * @param pseudo  Pseudo du joueur à créer (Chaine de caractères)
     * @param couleur Couleur du joueur (ROUGE ou BLEU)
     */
    Joueur(String pseudo, int couleur) {
        this.pseudo = pseudo;
        this.couleur = couleur;
    }

    public String toString() {
        String c;

        switch (couleur) {
            case ROUGE:
                c = Couleur.ROUGE_BCK + "[Rouge]" + Couleur.NORMALE_BCK;
                break;
            case BLEU:
                c = Couleur.BLEU_BCK + "[Bleu]" + Couleur.NORMALE_BCK;
                break;
            default:
                c = Couleur.NORMALE_BCK + "[Blanc]" + Couleur.NORMALE_BCK;
                break;
        }
            
        return c;
    }
}

/**
 * Classe définissant chaque case du plateau de jeu
 */
class Case {

    public static final int VIDE = 0;
    public static final int ROUGE = 1;
    public static final int BLEU = 2;
    public static final int OBSTACLE = 3;

    public static final int NORMAL = 0;
    public static final int SELECTIONNER = 1;
    public static final int IMMEDIAT = 2;
    public static final int DISTANT = 3;

    private int typeCase;
    private int position;

    /**
     * Constructeur de la classe case, contstruit une case vide
     * @param none Pas besoin de paramètre pour la case, elle est initialisé
     * vide
     */
    Case(){
        typeCase = VIDE;
        position = NORMAL;
    }

   Case(int typeCase){
        this.typeCase = typeCase;
        position = NORMAL;
   } 

    /**
     * @param typeCase Type de case à changer (VIDE, ROUGE, BLEU, OBSTACLE)
     */
    void setTypeCase(int typeCase) {
        this.typeCase = typeCase;
    }

    /**
     * @return Retourne le type de la case, la fonction retourne un entier
     */
    int getTypeCase(){
        return typeCase;
    }

    /**
     * @param position Change la position relative de la case, utiliser pour les
     * déplacements possible
     */
    void setPosition(int position){
        this.position = position;
    }
    /**
     * @return Retourne un entier correspondant a la position relative de la
     * case sélectionner
     */
    int getPosition(){
        return position;
    }

    public String toString() {

        String crochetG;
        String crochetD;
        String element;

        switch (position) {
            case NORMAL:
                crochetG = Couleur.NORMALE_FOR + "[";
                crochetD = Couleur.NORMALE_FOR + "]" + Couleur.NORMALE_FOR;
                break;
            
            case SELECTIONNER:
                crochetG = Couleur.JAUNE_FOR + "[";
                crochetD = Couleur.JAUNE_FOR + "]" + Couleur.NORMALE_FOR;
                break;

            case IMMEDIAT:
                crochetG = Couleur.VERT_FOR + "[";
                crochetD = Couleur.VERT_FOR + "]" + Couleur.NORMALE_FOR;
                break;

            case DISTANT:
                crochetG = Couleur.MAGENTA_FOR + "[";
                crochetD = Couleur.MAGENTA_FOR + "]" + Couleur.NORMALE_FOR;
                break;
            default:
                crochetG = Couleur.NORMALE_FOR + "[";
                crochetD = Couleur.NORMALE_FOR + "]" + Couleur.NORMALE_FOR;
                break;
        }

        switch(typeCase){

            case VIDE : 
                element = " ";
                break;
            case ROUGE : 
                element = Couleur.ROUGE_FOR + "\u25A0" + Couleur.NORMALE_FOR;
                break;
            case BLEU : 
                element = Couleur.BLEU_FOR + "\u25A0"+ Couleur.NORMALE_FOR;
                break;
            case OBSTACLE : 
                element = Couleur.JAUNE_FOR + "\u25A0"+ Couleur.NORMALE_FOR;
                break;
            default :
                element = " ";
                break;
        }
        return crochetG + element + crochetD;
    }
}

/**
 * Classe contenant le plateau de jeu
 */
class Plateau {
    
    private static final int LONGUEUR = 7;
    private static final int LARGEUR = 7;
    public static Scanner clavier;
    Case[][] board;

    /**
     * Création d'un tableau de case, les cases sont vides par défault
     */
    Plateau(){
        clavier = new Scanner(System.in);

        board = new Case[LARGEUR][LONGUEUR];
        for (int i = 0; i < LARGEUR; i++) {
            for (int j = 0; j < LONGUEUR; j++) {
                board[i][j] = new Case();
            }
        }

        init_plateau();
    }

    /**
     * Fonction d'intialisation du plateau de jeu, ne retourne rien et n'a pas
     * d'arguments
     */
    public void init_plateau() {

        // Cases de départ pour le joueur rouge
        board[0][0].setTypeCase(Case.ROUGE);
        board[6][6].setTypeCase(Case.ROUGE);

        // Cases de départ pour le joueur bleu
        board[0][6].setTypeCase(Case.BLEU);
        board[6][0].setTypeCase(Case.BLEU);

        // Placement des obsctacles
        board[2][3].setTypeCase(Case.OBSTACLE);
        board[3][2].setTypeCase(Case.OBSTACLE);
        board[3][4].setTypeCase(Case.OBSTACLE);
        board[4][3].setTypeCase(Case.OBSTACLE);

    }

    /**
     * Fonction d'affichage du plateau de jeu
     */
    public void afficherPlateau() {
        out.println();

        for (Case[] lignes : board) {
            for (Case element : lignes) {
                out.print(element);
            }
            out.println();
        }
        out.println();
    }


    public void selectionerCase(Joueur j) {
        int x;
        int y;
        
        while (true) {
            out.println(j + " Saisir une position a jouer (x espace y)");
            x = clavier.nextInt();
            y = clavier.nextInt();
            clavier.nextLine();
            // On vérifie qu'on ne se trouve pas en dehors du tableau
            if (x >= 0 && x <= 6 && y >= 0 && y <= 6) {
                // On vérifie que la case sélectionner contient un pion et que
                // ce n'est pas un obstacle
                if (board[x][y].getTypeCase() != Case.VIDE || 
                    board[x][y].getTypeCase() != Case.OBSTACLE) {
                    // On vérifie que la couleur est la bonne
                    if (j.couleur == board[x][y].getTypeCase()) {
                        break;
                    }
                }
            }
            out.println(j + " Postion incorrecte, veuillez re-essayer");
        }

        afficherDeplacement(board[x][y], x, y);

    }

    public void afficherDeplacement(Case c, int x, int y) {

        c.setPosition(Case.SELECTIONNER);

        // Boucle pour le déplacement immediat
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                    if (board[x+i][y+j].getTypeCase() == Case.VIDE) {
                        board[x+i][y+j].setPosition(Case.IMMEDIAT);
                    }
                }
            }
        }

        // Boucle pour le déplacement distant
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                    if (board[x+i][y+j].getTypeCase() == Case.VIDE && 
                        board[x+i][y+j].getPosition() != Case.IMMEDIAT) {
                            board[x+i][y+j].setPosition(Case.DISTANT);
                    }
                }
            }
        }

        afficherPlateau();
    }

    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j = new Joueur("Bob Ross", Joueur.ROUGE);

        p.afficherPlateau();
        p.selectionerCase(j);

    }

}

/**
 * Classe contenant le déroulement de la partie du jeu Ataxx
 */
class Ataxx {

}