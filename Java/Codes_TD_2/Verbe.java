
public class Verbe {
    
   static final String sujets[] = {"je","tu","il","nous","vous","ils"};
   static final String terminaison[] = {"e", "es", "e", "ons", "ez", "ent"};
   static final String terminaison_verbe = "er";

    public static void conjuguer(String racineVerbe){
        for (int i = 0; i < sujets.length; i++) {
            System.out.println(sujets[i] + " " + racineVerbe + terminaison[i]);
        }
    }

    public static void main(String[] args) {
     
    String verbe = args[0];

    if(verbe.endsWith(terminaison_verbe)){
        String racineVerbe = verbe.substring(0, verbe.length() - terminaison_verbe.length());
        conjuguer(racineVerbe);
    }

    }
}
