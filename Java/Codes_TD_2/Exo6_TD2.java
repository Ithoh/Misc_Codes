class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean sontIdentiques(Point a, Point b) {
        return ((a.x == b.x) && (a.y == b.y));
    }

    public boolean estIdentique(Point a) {
        return ((a.x == x) && (a.y == y));
    }
}

class PointNom extends Point {
    private char nom;

    public PointNom(int x, int y, char nom) {
        super(x, y);
        this.nom = nom;
    }

    public static boolean sontIdentiques(PointNom a, PointNom b) {
        return PointNom.sontIdentiques(a,b) && (((PointNom)a).nom == ((PointNom)b).nom);
    }

    public boolean estIdentique(PointNom a) {
        return(super.estIdentique(a) && (nom == ((PointNom)a).nom));
    }
}

class TD2_exo6 {
    public static void main (String [] args) {

        Point p = new Point(2,4);
        PointNom pn1 = new PointNom(2,4,'A');
        PointNom pn2 = new PointNom(2,4,'B');
        System.out.println(pn1.estIdentique(pn2)); // Appelle de la methode estIdentique 
        System.out.println(p.estIdentique(pn1)); // Appelle de la methode estIdentique
        System.out.println(pn1.estIdentique(p)); // Appelle de la methode estIdentique
        System.out.println(Point.sontIdentiques(pn1,pn2));  // Appelle de la methode sontIdentique
    }
}