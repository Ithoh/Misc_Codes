public class exo6 {
    public static void main(String[] args) {
        int i = 1;
        try {
            for (; i < 6; i++) {
                JavaFun.maFonction(i);
            }
        } catch (monException e) {
            System.out.println("Main catch : " + e);
        } finally {
            System.out.println("Main finally : " + i);
        }
        
    }
}

class monException extends Exception {
    private int valeur;

    public monException(int n) {
        valeur = n;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "MonException :"+'\n'+"Valeur = " + valeur;
    }
}

class JavaFun{
    public static void maFonction(int n) throws monException {
        try {
            if (n != 1) {
                throw new monException(n);
            }
        } catch (monException e) {
            System.out.println("maFonction : "+e);
            throw e;
        }finally{
            System.out.println("Finally : Valeur de l'argument n = " + n);
        }
    }
}