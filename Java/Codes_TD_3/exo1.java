abstract class exo1 {
    protected double xA, yA, xB, yB;
    abstract void calculPerimetre();
    abstract void calculSurface();

    public exo1(double xA, double yA, double xB, double yB){
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
    }

    @Override
    public String toString() {
        return "Point A = " + xA + ", yA = " + yA + "\nPoint B = " + xB + ", yB = " + yB;
    }
}

class Rectangle extends exo1 {

    private double longeur;
    private double largeur;
    private double perimetre;
    private double surface;

    public Rectangle(double xA, double yA, double xB, double yB){
        super(xA, yA, xB, yB);
    }

    void calculPerimetre(){
        longeur = Math.abs(xA - xB);
        largeur = Math.abs(yA - yB);
        perimetre = longeur * 2 + largeur * 2;
    }

    void calculSurface(){
        surface = longeur * largeur;
    }
}

class Cercle extends exo1{

    private double diametre;
    private double perimetre;
    private double surface;

    public Cercle(double xA, double yA, double xB, double yB){
        super(xA, yA, xB, yB);
        diametre = Math.sqrt( Math.pow((xA - xB),2) +  Math.pow((yA - yB),2));
    }

    void calculPerimetre(){
        perimetre = diametre * Math.PI;
    }

    void calculSurface(){
        surface = Math.pow(a, b)
    }

}