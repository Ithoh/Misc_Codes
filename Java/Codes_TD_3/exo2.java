public class exo2 implements Affichable, Tranformable{

    private double xA, xB, yA, yB;

    public exo2(double xA, double xB, double yA, double yB) {
        this.xA = xA;
        this.xB = xB;
        this.yA = yA;
        this.yB = yB;
    }

    public void afficher(){
        System.out.println("Afficher rectangle");
    }

    public void homothetie(double angle){
        System.out.println("Homothetie : " + angle);
    }

    public void rotation(double angle){
        System.out.println("Rotation : " + angle);
    }

    public static void main(String[] args) {
        exo2 e = new exo2(1,2,3,4);
        e.afficher();
        e.rotation(4);
        e.homothetie(8);
    }
}

interface Affichable{
    void afficher();
}

interface Tranformable{
    void rotation(double angle);
    void homothetie(double valeur);
}