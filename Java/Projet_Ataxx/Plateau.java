import static java.lang.System.out;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Classe contenant le plateau de jeu
 */
public class Plateau {
    
    private static final int LONGUEUR = 7;
    private static final int LARGEUR = 7;
    public static Scanner clavier;
    Case[][] board;

    /**
     * Cr\u00E9ation d'un tableau de case, les cases sont vides par défault
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
     * @param p Joueur devant sélectionner un pion à bouger
     * @param p2 Joueur numéro 2 de la partie en cours
     */
    public void selectionerCase(Joueur p, Joueur p2) {
        int x;
        int y;

        afficherPlateau();

        // Tant que la position saisie n'est pas correcte on demande au joueur
        // de saisir une position
        while (true) {
            out.println(p + " - Saisir une position a jouer (x espace y)");
            x = clavier.nextInt() - 1;
            y = clavier.nextInt() - 1;
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
           out.println(p + " - Postion saisie incorrecte, veuillez re-essayer");
        }

        afficherDeplacementPossible(p, p2, board[x][y], x, y);

    }

    /**
     * Methode affichant les déplacements possibles en fonction de la 
     * sélection du joueur au précédant
     * 
     * @param p Joueur en cours
     * @param p2 Deuxième joueur de la partie en cours
     * @param c Case sélectionner par le joueur donner par selectionnerCase()
     * @param x Coordonné x de la case sélectionner par le joueur
     * @param y Coordonné y de la case sélectionner par le joueur
     */
    public void afficherDeplacementPossible(Joueur p, Joueur p2, Case c, int x, int y) {

        // On modifie l'attribut Position de la case sélectionner pour
        // savoir laquelle est sélectionnée
        c.setPosition(Case.SELECTIONNER);

        // Boucle pour le déplacement immediat
        // On change la valeur de l'attribut position pour toutes les cases
        // dans le voisinage immediat de la case sélectionnée
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
        // On change la valeur de l'attribut position pour toutes les cases
        // dans le voisinage distant de la case sélectionnée
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
     * @param p Joueur en cours
     * @param p2 Deuxième joueur de la partie en cours
     * @param x Coordonné x de la case sélectionner par le joueur
     * @param y Coordonné y de la case sélectionner par le joueur
     */
    public void deplacerPion(Joueur p, Joueur p2, int x, int y){

        String choix;
        Point element;
        // On créer la table de hash contenant tout les mouvements possible
        // d'un pion
        HashMap<String, Point> mouvements = creerMouvements();

        // Tant que le mouvement saise est incorrect on demande au joueur
        // de saisir un mouvement pour le pion sélectionné
        while (true) {
            out.println(p + " - Saisir un mouvement \u00E0 r\u00E9aliser");
            choix = clavier.nextLine();

            // On regarde si le mouvement saisis existe, si la chaine de 
            // de caractère saisie par le joueur n'existe pas dans les 
            // mouvements possible on demande d'en re-saisir une autre
            if ( (element = mouvements.get(choix) ) != null) {
                // On vérifie que le mouvement est possible, donc qu'il ne sort
                // pas du plateau de jeu
                if (choix.equals("p")) {
                    out.println(p + " - Passe son tour");
                    break;
                }
                else{
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
            }

            afficherPlateau();
            out.println(p + " - Mouvement impossible ! Veuillez re-essayer");
        }
        
        reinitialiserDeplacementsPossible();
        afficherPlateau();
        try {
            infecter(p, p2, x+element.x, y+element.y);
        } catch (Exception e) {
            out.println("Ceci n'est pas censé arriver");
        }
    }

    /**
     * Méthode pour infecter les pions adverse dans un rayon immediat
     * @param p Joueur en cours qui effectue l'infection
     * @param p2 Deuxième joueur de la partie qui subit l'infection
     * @param x Coordonné x du pion déplacé précédemment
     * @param y Coordonné y du pion déplacé précédemment
     * @throws InterruptedException - Retourne une exception si le Thread.sleep()
     * rate
     */
    public void infecter(Joueur p, Joueur p2, int x, int y) 
                         throws InterruptedException{
        
        int nbrInfections = 0;
        // On effectue un switch case sur le joueur en cours pour determiner sa 
        // couleur
        switch (p.couleur) {
            case Joueur.ROUGE:
                // Boucle dans le voisinage immediat du pion déplacé
                // pour vérifier si il y a des pions bleu présent pour les
                // infecter
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion bleu y est présent, on lui met le 
                            // status d'infecter
                            if (board[x+i][y+j].getTypeCase() == Case.BLEU){
                                board[x+i][y+j].setPosition(Case.INFECTER);
                                p.nbrPions++;
                                p2.nbrPions--;
                                nbrInfections++;
                            }
                        }
                    }
                }
                if (nbrInfections == 0) {
                    break;
                }

                afficherPlateau();
                out.println(p + " - Infecte l'adversaire");
                Thread.sleep(2000);

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion bleu avec le status infecter est 
                            // présent on le remplace par un pion rouge
                            if (board[x+i][y+j].getPosition() == Case.INFECTER){
                                board[x+i][y+j].setTypeCase(Case.ROUGE);
                                board[x+i][y+j].setPosition(Case.NORMAL);
                            }
                        }
                    }
                }

                break;
        
            case Joueur.BLEU:
                // Boucle dans le voisinage immediat du pion déplacé
                // pour vérifier si il y a des pions rouge présent pour les
                // infecter
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion a le status infecter on le remplace
                            // par la couleur adverse
                            if (board[x+i][y+j].getTypeCase() == Case.ROUGE) {
                                board[x+i][y+j].setPosition(Case.INFECTER);
                                p.nbrPions++;
                                p2.nbrPions--;
                                nbrInfections++;
                            }
                        }
                    }
                }

                if (nbrInfections == 0) {
                    break;
                }

                afficherPlateau();
                out.println(p + " - Infecte l'adversaire");
                Thread.sleep(2000);

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(x+i >= 0 && x+i <= 6 && y+j >= 0 && y+j <= 6){
                            // Si un pion a le status infecter on le remplace
                            // par la couleur adverse
                            if (board[x+i][y+j].getPosition() == Case.INFECTER){
                                board[x+i][y+j].setTypeCase(Case.BLEU);
                                board[x+i][y+j].setPosition(Case.NORMAL);
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
     * @return - La m\u00E9tode retourne une table de hash contenant tous 
     * les d\u00E9placements possible, ainsi qu'un objet point ayant pour
     * attribut x et y les coordonn\u00E9es pour le d\u00E9placement sur
     * le plateau de jeu
     */
    public HashMap<String, Point> creerMouvements(){

        HashMap<String, Point> Mouvements = new HashMap<String, Point>();

        // Mouvements immediats
        Mouvements.put("1", new Point(1, -1));
        Mouvements.put("2", new Point(1, 0));
        Mouvements.put("3", new Point(1, 1));
        Mouvements.put("4", new Point(0, -1));
        Mouvements.put("p", new Point(0, 0));
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
     * @param j1 Joueur 1 de la partie en cours
     * @param j2 Joueur 2 de la partie en cours
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