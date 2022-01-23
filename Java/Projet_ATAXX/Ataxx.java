import static java.lang.System.out;
import java.util.HashMap;
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
 * Classe utilisé pour la génération des déplacements possibles
 */
class Point{
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
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
    int nbrPions;

    /**
     * @param pseudo  Pseudo du joueur à créer (Chaine de caractères)
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
     * Retour possible : Case.VIDE, Case.ROUGE, Case.BLEU, Case.OBSTACLE
     */
    int getTypeCase(){
        return typeCase;
    }

    /**
     * @param position Change la position relative de la case, utiliser pour les
     * déplacements possible (NORMAL, SELECTIONNER, IMMEDIAT, DISTANT)
     * 
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
     * Methode d'intialisation du plateau de jeu, ne retourne rien et n'a pas
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
     * Methode d'affichage du plateau de jeu
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

    /**
     * Methode demandant au joueur de sélectionner à pion à deplacer
     * 
     * @param p - Joueur devant sélectionner un pion à bouger
     */
    public void selectionerCase(Joueur p, Joueur p2) {
        int x;
        int y;
        
        afficherPlateau();

        while (true) {
            out.println(p + " - Saisir une position a jouer (x espace y)");
            x = clavier.nextInt();
            y = clavier.nextInt();
            clavier.nextLine();
            // On vérifie qu'on ne se trouve pas en dehors du tableau
            if (x >= 0 && x <= 6 && y >= 0 && y <= 6) {
                // On vérifie que la case sélectionner contient un pion et que
                // ce n'est pas un obstacle
                if (board[x][y].getTypeCase() != Case.VIDE || 
                    board[x][y].getTypeCase() != Case.OBSTACLE) {
                    // On vérifie que la couleur sélectionner est la bonne
                    if (p.couleur == board[x][y].getTypeCase()) {
                        break;
                    }
                }
            }

            afficherPlateau();
            out.println(p + " - Postion incorrecte, veuillez re-essayer");
        }

        afficherDeplacementPossible(p, p2, board[x][y], x, y);

    }

    /**
     * Methode affichant les déplacements possibles en fonction de la 
     * sélection du joueur au précédant
     * 
     * @param p - Joueur en cours
     * @param c - Case sélectionner par le joueur donner par selectionnerCase()
     * @param x - Coordonné x de la case sélectionner par le joueur
     * @param y - Coordonné y de la case sélectionner par le joueur
     */
    public void afficherDeplacementPossible(Joueur p, Joueur p2, Case c, int x, int y) {

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
        deplacerPion(p, p2, x, y);
    }

    /**
     * Méthode de saisie du déplacement voulu, et déplacement du pion
     * @param p - Joueur en cours
     * @param x - Coordonné x de la case sélectionner par le joueur
     * @param y - Coordonné y de la case sélectionner par le joueur
     */
    public void deplacerPion(Joueur p, Joueur p2, int x, int y){

        String choix;
        Point element;
        HashMap<String, Point> mouvements = creerMouvements();

        while (true) {
            out.println(p + " - Saisir un mouvement \u00E0 r\u00E9aliser");
            choix = clavier.nextLine();

            // On regarde si le mouvement saisis existe
            if ( (element = mouvements.get(choix) ) != null) {
                // On vérifie que le mouvement est possible
                if(element.x + x >= 0 && element.x + x <= 6 &&
                   element.y + y >= 0 &&  element.y + y <= 6){
                    // On change la case de destination par la couleur du joueur en cours
                    // On vérifie le type de mouvement pour déplacer le pion de la bonne
                    // Manière
                    if (board[x + element.x][y + element.y].getPosition() == Case.DISTANT &&
                        board[x + element.x][y + element.y].getTypeCase() == Case.VIDE) {
                        // Le pion d'origine est supprimé
                        board[x][y].setTypeCase(Case.VIDE);
                        board[x + element.x][y + element.y].setTypeCase(p.couleur);
                        break;
                    } else if (board[x + element.x][y + element.y].getTypeCase() == Case.VIDE) {
                        board[x + element.x][y + element.y].setTypeCase(p.couleur);
                        p.nbrPions++;
                        break;
                    }
                }
            }

            afficherPlateau();
            out.println(p + " - Mouvement impossible !");
        }
        
        reinitialiserDeplacementsPossible();
        afficherPlateau();
        infecter(p, p2, x+element.x, y+element.y);
    }

    /**
     * Méthode pour infecter les pions adverse dans un rayon immediat
     * @param x - Coordonné x du pion déplacé précédemment
     * @param y - Coordonné y du pion déplacé précédemment
     */
    public void infecter(Joueur p, Joueur p2, int x, int y){
        
        switch (p.couleur) {
            case Joueur.ROUGE:
                // Boucle dans le voisinage immediat du pion déplacé
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion bleu y est présent, on le remplace
                            if (board[x+i][y+j].getTypeCase() == Case.BLEU) {
                                board[x+i][y+j].setTypeCase(Case.ROUGE);
                                p.nbrPions++;
                                p2.nbrPions--;
                            }
                        }
                    }
                }
                break;
        
            case Joueur.BLEU:
                // Boucle dans le voisinage immediat du pion déplacé
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion rouge y est présent, on le remplace
                            if (board[x+i][y+j].getTypeCase() == Case.ROUGE) {
                                board[x+i][y+j].setTypeCase(Case.BLEU);
                                p.nbrPions++;
                                p2.nbrPions--;
                            }
                        }
                    }
                }
                break;

            default:
                break;
        }
        
        afficherPlateau();
    }


    /**
     * Methode retournant une table de hash contenant tous les déplacements
     * possibles
     */
    public HashMap<String, Point> creerMouvements(){

        HashMap<String, Point> Mouvements = new HashMap<String, Point>();

        // Mouvements immediats
        Mouvements.put("1", new Point(1, -1));
        Mouvements.put("2", new Point(1, 0));
        Mouvements.put("3", new Point(1, 1));
        Mouvements.put("4", new Point(0, -1));
        Mouvements.put("6", new Point(0, 1));
        Mouvements.put("7", new Point(-1, -1));
        Mouvements.put("8", new Point(-1, 0));
        Mouvements.put("9", new Point(-1, 1));

        // Mouvements distants
        Mouvements.put("51", new Point(2, -2));
        Mouvements.put("521", new Point(2, -1));
        Mouvements.put("52", new Point(2, 0));
        Mouvements.put("523", new Point(2, 1));
        Mouvements.put("53", new Point(2, 2));
        Mouvements.put("563", new Point(1, 2));
        Mouvements.put("56", new Point(0, 2));
        Mouvements.put("569", new Point(-1, 2));
        Mouvements.put("59", new Point(-2, 2));
        Mouvements.put("589", new Point(-2, 1));
        Mouvements.put("58", new Point(-2, 0));
        Mouvements.put("587", new Point(-2, -1));
        Mouvements.put("57", new Point(-2, -2));
        Mouvements.put("547", new Point(-2, -1));
        Mouvements.put("54", new Point(0, -2));
        Mouvements.put("541", new Point(1, -2));

        return Mouvements;
    }

    /**
     * Méthode permettant de vérifier si il y a un vainqueur dans la partie
     * Méthode à appeler après une infection, c'est a dire la fin d'un tour 
     * de jeu
     * @param j1 - Joueur 1 de la partie en cours
     * @param j2 - Joueur 2 de la partie en cours
     */
    public void verifierVainqueur(Joueur j1, Joueur j2){

        int nbrCasesVides = 0;

        // On compte le nombre de cases vides restantes sur le plateau
        // Pour gérer le cas oú toutes les cases sont occupées
        for (Case[] cases : board) {
            for (Case pions : cases) {
                if (pions.getTypeCase() == Case.VIDE) {
                    nbrCasesVides++;
                }
            }
        }

        switch (nbrCasesVides) {
            // toutes les cases sont prises, le gagnant est donc celui avec
            // le plus de pions
            case 0:
                // Le joueur 1 à plus de pions
                if (j1.nbrPions > j2.nbrPions) {
                    out.println("Victoire de " + j1);
                    System.exit(0);
                }
                // Le joueur 2 à plus de pions
                else if(j2.nbrPions > j1.nbrPions){
                    out.println("Victoire de " + j2);
                    System.exit(0);
                }
                // Les deux joueurs ont le même nombre de pions, égalité
                else if (j1.nbrPions == j2.nbrPions){
                    out.println("Egalit\u00E9 !");
                    System.exit(0);
                }
            
            // toutes les cases ne sont pas prises, on regarde donc le nombre
            // de pions de chaque joueur
            default:
                // Le joueur 2 n'a plus de pions, il a perdu, victoire de 
                // joueur 1
                if (j2.nbrPions == 0 && j1.nbrPions != 0) {
                    out.println("Victoire de " + j1);
                    System.exit(0);
                }
                // Le joueur 1 n'a plus de pions, il a perdu, victoire de 
                // joueur 1
                else if (j1.nbrPions == 0 && j2.nbrPions != 0){
                    out.println("Victoire de " + j2);
                    System.exit(0);
                }

                break;
        }
    }

    /**
     * Fonction qui re-initialise les déplacements possible
     */
    public void reinitialiserDeplacementsPossible(){
        for (Case[] lignes : board) {
            for (Case element : lignes) {
                element.setPosition(Case.NORMAL);
            }
        }
    }

}

/**
 * Classe contenant le déroulement de la partie du jeu Ataxx
 */
class Ataxx {

    Joueur j1;
    Joueur j2;
    Joueur joueurCourant;
    Plateau board;

    Ataxx(){
        // On créer le plateau de jeu
        board = new Plateau();
        
        out.println("Veuillez entrz un pseudo pour le joueur 1 (Rouge)");
        j1 = new Joueur(Plateau.clavier.nextLine(),Joueur.ROUGE);
        out.println("Veuillez entrz un pseudo pour le joueur 2 (Bleu)");
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
        Ataxx nouvellePartie = new Ataxx();
        nouvellePartie.lancerPartie();
    }
}