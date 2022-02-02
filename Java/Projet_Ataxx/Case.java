/**
 * Classe d\u00E9finissant chaque case du plateau de jeu
 * @author L\u00E9o Delas
 * @see Couleur
 * @see Joueur
 * @see Ataxx
 * @see Plateau
 * @see Point
 */
public class Case {

    /** Variable concernant le type de la case, et son contenu */
    public static final int VIDE = 0;
    /** Variable concernant le type de la case, et son contenu */
    public static final int ROUGE = 1;
    /** Variable concernant le type de la case, et son contenu */
    public static final int BLEU = 2;
    /** Variable concernant le type de la case, et son contenu */
    public static final int OBSTACLE = 3;

    /** Variable concernant l'etat de la case */
    public static final int NORMAL = 0;
    /** Variable concernant l'etat de la case */
    public static final int SELECTIONNER = 1;
    /** Variable concernant l'etat de la case */
    public static final int IMMEDIAT = 2;
    /** Variable concernant l'etat de la case */
    public static final int DISTANT = 3;
    /** Variable concernant l'etat de la case */
    public static final int INFECTER = 4;

    private int typeCase;
    private int etat;

    /**
     * Constructeur de la classe case, contstruit une case vide
     * Pas besoin de paramètre pour la case, elle est initialisé
     * vide
     */
    Case(){
        typeCase = VIDE;
        etat = NORMAL;
    }

   Case(int typeCase){
        this.typeCase = typeCase;
        etat = NORMAL;
   } 

    /**
     * Permet de changer le type de la case voulut
     * @param typeCase Type de case à changer (VIDE, ROUGE, BLEU, OBSTACLE)
     */
    public void setTypeCase(int typeCase) {
        this.typeCase = typeCase;
    }

    /**
     * Retourne le type de la case
     * @return Retourne le type de la case, la fonction retourne un entier
     * Retour possible : Case.VIDE, Case.ROUGE, Case.BLEU, Case.OBSTACLE
     */
    public int getTypeCase(){
        return typeCase;
    }

    /**
     * Permet de changer l'etat de la case
     * @param etat Change l'etat relatif de la case, utiliser pour les
     * déplacements possible (NORMAL, SELECTIONNER, IMMEDIAT, DISTANT)
     * 
     */
    public void setEtat(int etat){
        this.etat = etat;
    }
    /**
     * Retourne l'etat de la case
     * @return Retourne un entier correspondant a la etat relative de la
     * case sélectionner
     */
    public int getEtat(){
        return etat;
    }

    /** 
     * Methode d'affichage d'une case, la couleur du pion ainsi que les crochets
     * l'entourant sont gerer selon les valeurs propres a la case, c'est a dire
     * le typeCase et etat
     * @return Retourne une chaine de caracteres
    */
    public String toString() {

        String crochetG;
        String crochetD;
        String element;

        switch (etat) {
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
            case INFECTER:
                if (getTypeCase() == ROUGE) {
                    crochetG = Couleur.BLEU_FOR + "[";
                    crochetD = Couleur.BLEU_FOR + "]" + Couleur.NORMALE_FOR;

                } else if (getTypeCase() == BLEU) {
                    crochetG = Couleur.ROUGE_FOR + "[";
                    crochetD = Couleur.ROUGE_FOR + "]" + Couleur.NORMALE_FOR;

                } else{
                    crochetG = Couleur.NORMALE_FOR + "[";
                    crochetD = Couleur.NORMALE_FOR + "]" + Couleur.NORMALE_FOR;
                }
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