import static java.lang.System.out;

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
        String c = (couleur == ROUGE) ? "Rouge" : (couleur == BLEU) ? "Bleu" 
                 : "Sans couleur";
        return pseudo + " " + c;
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

    private int typeCase;

    /**
     * Constructeur de la classe case, contstruit une case vide
     * @param none Pas besoin de paramètre pour la case, elle est initialisé
     * vide
     */
    Case(){
        typeCase = VIDE;
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

    public String toString(){

        String affichage;

        switch(typeCase){

            case VIDE : 
                affichage = "";
                break;
            case ROUGE : 
                affichage = Couleur.ROUGE_FOR + "■" + Couleur.NORMALE_FOR;
                break;
            case BLEU : 
                affichage = Couleur.BLEU_FOR + "■"+ Couleur.NORMALE_FOR;
                break;
            case OBSTACLE : 
                affichage = Couleur.JAUNE_FOR + "■"+ Couleur.NORMALE_FOR;
                break;
            default :
                affichage = "";
                break;
        }
        return affichage;
    }
}

/**
 * Classe contenant le plateau de jeu
 */
class Plateau {
    
    Case[][] plateau;

    /**
     * Création d'un tableau de case, les cases sont vides par défault
     */
    Plateau(){
        plateau = new Case[7][7];
        // ATTENTION CONSTRUIRE LES OBJETS !!!!!!
        init_plateau();
    }

    /**
     * Fonction d'intialisation du plateau de jeu, ne retourne rien et n'a pas
     * d'arguments
     */
    public void init_plateau(){
        // Cases de départ pour le joueur rouge
    
        plateau[0][0].setTypeCase(Case.ROUGE);
        plateau[6][6].setTypeCase(Case.ROUGE);

        // Cases de départ pour le joueur bleu
        plateau[0][6].setTypeCase(Case.BLEU);
        plateau[6][0].setTypeCase(Case.BLEU);

        // Placement des obsctacles
        plateau[2][3].setTypeCase(Case.OBSTACLE);
        plateau[3][2].setTypeCase(Case.OBSTACLE);
        plateau[3][4].setTypeCase(Case.OBSTACLE);
        plateau[4][3].setTypeCase(Case.OBSTACLE);

    }

    /**
     * Fonction d'affichage du plateau de jeu
     */
    public void afficherPlateau(){
        for (Case[] lignes : plateau) {
            for (Case element : lignes) {
                out.println("[" + element + "]");
            }
        }
    }

    public static void main(String[] args) {
        Plateau p = new Plateau();
        p.afficherPlateau();
    }

}

/**
 * Classe contenant le déroulement de la partie du jeu Ataxx
 */
class Ataxx {

}