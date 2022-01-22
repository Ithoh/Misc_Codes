public class Exo3 {

    static int compteur = 0;
    int n;

    public Exo3() {
        n=++compteur;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Adios amigo ! " + n);  
    }

    public static void main(String[] args) {

        while (true) {
            new Exo3();
        }
    }
}
