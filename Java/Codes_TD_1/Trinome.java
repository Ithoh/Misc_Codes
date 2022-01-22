import java.lang.Math;

class Trinome {
    
    double a;
    double b;
    double c;
    double determinant;
    double racine1;
    double racine2;

    Trinome(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void afficherAttributs(){
        System.out.println("\nValeur de a : " + a + "\n" +
                           "Valeur de b : " + b + "\n" +
                           "Valeur de c : " + c);
    }

    void calculerRacines(){

        determinant = (b*b) - 4 * a * c; 

        if (determinant < 0) {
            racine1 = -(b/ (2*a));
            racine2 = Math.sqrt(-determinant) / (2*a);
        }
        else if (determinant == 0) {
            racine1 = -(b / (2*a));
            racine2 = racine1;
        }
        else if (determinant > 0){
            racine1 = (-b + Math.sqrt(determinant)) / (2*a);
            racine2 = (-b - Math.sqrt(determinant)) / (2*a);
        }
    }

    void afficherRacines(){

        if (determinant < 0) {

            System.out.println("Le determinant est inférieur à 0, il vaut : " + determinant +
                               "\nRacine complexe 1 : " + racine1 + " + " + racine1 + "i" +
                               "\nRacine complexe 2 : " + racine2 + " - " + racine2 + "i");
        }
        else if (determinant == 0) {

            System.out.println("Le determinant est égal à zéro, les racines sont égales" + 
            "\nleur valeur est : " + racine1);
        }
        else if (determinant > 0) {

            System.out.println("Le determinant est supérieur à zéro, il vaut : " + determinant + 
                               "\nRacine 1 : " + racine1 + "\n" + "Racine 2 : " + racine2);
        }
    }

    public static void main(String[] args) {
        
        // Trinome positif
        Trinome fonction1 = new Trinome(2, -5 , -3);
        fonction1.afficherAttributs();
        fonction1.calculerRacines();
        fonction1.afficherRacines();

        // Trinome égale a 0
        Trinome fonction2 = new Trinome(9, 6, 1);
        fonction2.afficherAttributs();
        fonction2.calculerRacines();
        fonction2.afficherRacines();

        // Trinome complexe
        Trinome fonction3 = new Trinome(2, 10, 25);
        fonction3.afficherAttributs();
        fonction3.calculerRacines();
        fonction3.afficherRacines();
    }
}
