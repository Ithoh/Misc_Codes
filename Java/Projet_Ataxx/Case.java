/**
 * Classe d\u00E9finissant chaque case du plateau de jeu
 */
public class Case {

    public static final int VIDE = 0;
    public static final int ROUGE = 1;
    public static final int BLEU = 2;
    public static final int OBSTACLE = 3;

    public static final int NORMAL = 0;
    public static final int SELECTIONNER = 1;
    public static final int IMMEDIAT = 2;
    public static final int DISTANT = 3;
    public static final int INFECTER = 4;

    private int typeCase;
    private int position;

    /**
     * Constructeur de la classe case, contstruit une case vide
     * Pas besoin de paramètre pour la case, elle est initialisé
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