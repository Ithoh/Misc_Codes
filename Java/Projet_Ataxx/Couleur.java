/**
 * Classe enum\u00E9r\u00E9 contenant les couleurs pour colorer le terminal
 */
public enum Couleur {
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