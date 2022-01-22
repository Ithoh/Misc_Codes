class Point2D {
    
    private double x;
    private double y;
    private double norme;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
        this.norme = -1;
    }

    public String toString() {

        if (norme < 0) {
            calculerNorme();
        }

        return "X : " + x + "\nY : " + y + "\nNorme : " + norme;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getNorme() {
        return norme;
    }

    public void calculerNorme(){
        this.norme = Math.sqrt(x * x + y * y);
    }

    public void setNorme(double reelPositif) {
        this.norme = reelPositif;
    }

    public double calculerProduitScalaire(Point2D p){
        double result;
        result = x*p.x + y*p.y;
        return result;
    }

    public void afficherProduitScalaire(Point2D p){
        System.out.println("Produit scalaire : " + this.calculerProduitScalaire(p)); 
    }

    public static void main(String[] args) {

        Point2D p1 = new Point2D(10, 20);
        Point2D p2 = new Point2D(5, 10);

        System.out.println(p1);
        System.out.println(p2);
        
        p1.afficherProduitScalaire(p2);
        p2.afficherProduitScalaire(p1);

    }
}

class Point3D extends Point2D{

    private double z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public String toString(){
        
        if (getNorme() < 0) {
            calculerNorme();
        }
        return "X : " + getX() + "\nY : " + getY() + "\nZ : " + z + "\nNorme : "
         + getNorme();
    }

    public void calculerNorme(){
        double x = getX();
        double y = getY();
        double norme = Math.sqrt(x * x + y * y + z * z);
        setNorme(norme);
    }

    public double calculerProduitScalaire(Point3D p){
        return super.calculerProduitScalaire(p) + z * p.z;
    }

    public void afficherProduitScalaire(Point3D p){
        System.out.println("Produit Scalaire : " + calculerProduitScalaire(p));
    }

    public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(3, 2, 1);

        System.out.println(p1);
        System.out.println(p2);

        p1.afficherProduitScalaire(p2);
        p2.afficherProduitScalaire(p1);
    }
}