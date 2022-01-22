import java.util.Calendar;

class Personne {

    static int nbrPersonne = 1;
    int id;
    String nom;
    String prenom;
    int annee;
    int age;

    Personne(String nom, String prenom, int annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
        id = nbrPersonne;
        nbrPersonne++;
    }

    void afficherIdentiter(){

        System.out.println("Numéro de creation : " + id + 
                           "\nNom : " + nom + 
                           "\nPrenom : " + prenom + 
                           "\nAnnee : " + annee);
        if (age != 0){
            System.out.println("Age : " + age);
        }
        System.out.println("");
    }

    void calculerAge(){
        Calendar cal = Calendar.getInstance();
        age = cal.get(Calendar.YEAR) - annee;
    }

    public static void main(String args[]){

        Personne p1 = new Personne("Léo", "Delas", 2000);
        Personne p2 = new Personne("Damien", "Dos Santos", 1998);
        p1.afficherIdentiter();
        p1.calculerAge();
        p1.afficherIdentiter();

        p2.afficherIdentiter();
        p2.calculerAge();
        p2.afficherIdentiter();
    }
}
