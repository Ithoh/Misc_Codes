/**
 * Classe utilis\u00E9 pour la g\u00E9n\u00E9ration des d\u00E9placements 
 * possibles, elle contient que deux champs, correspondant \u00E0 des 
 * coordon\u00E9es x et y
 * @author L\u00E9o Delas
 * @see Case
 * @see Couleur
 * @see Joueur
 * @see Ataxx
 * @see Plateau
 */
public class Point{

    /**
     * Coordon\u00E9es x dans le plateau de jeu
     */
    public int x;

    /**
     * Coordon\u00E9es y dans le plateau de jeu
     */
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}