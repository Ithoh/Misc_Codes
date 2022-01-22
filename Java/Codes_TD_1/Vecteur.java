public class Vecteur {
    
    int x;
    int y;
    int z;
    double norme = 0.0;

    Vecteur(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void afficherVecteur(){
        System.out.println("x : " + x + "\ny : " + y + "\nz : " + z);
    }

    public void calculerNorme(){
        this.norme = Math.sqrt(x * x + y * y + z * z);
    }

    public void afficherNorme(){
        System.out.println("norme : "+ norme);
    }

    public void sommerDeuxVecteur(Vecteur vect1){

        x += vect1.x;
        y += vect1.y;
        z += vect1.z;
    }

    public int produitScalaireVecteur(Vecteur vect1){

        int result;
        result = x*vect1.x + y*vect1.y + z*vect1.z;
        return result;
    }

    public static void main(String[] args) {

        Vecteur v2 = new Vecteur(10, 10 ,10);
        Vecteur v = new Vecteur(3, 8, 10);
        v.afficherVecteur();

        v.calculerNorme();
        v.afficherNorme();

        v.sommerDeuxVecteur(v2);
        v.afficherVecteur();

        System.out.println("Resultat du produit scalaire : " + v.produitScalaireVecteur(v2));
    }
}
