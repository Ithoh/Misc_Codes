import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.awt.Color.*;

public class Exercice5 extends JFrame implements ItemListener {
    
    JMenuBar barre;
    JMenu couleur;
    JRadioButtonMenuItem rouge, vert, bleu;
    JPanel panel;

    Exercice5(String nom){
        super(nom);

        panel = new JPanel();
        add(panel);

        // Création de la barre de menu
        barre = new JMenuBar();
        setJMenuBar(barre);

        // Création du menu couleur
        couleur = new JMenu("Couleur");
        barre.add(couleur);

        rouge = new JRadioButtonMenuItem("Rouge");
        vert = new JRadioButtonMenuItem("Vert");
        bleu = new JRadioButtonMenuItem("Bleu");

        rouge.addItemListener(this);
        vert.addItemListener(this);
        bleu.addItemListener(this);

        couleur.add(rouge);
        couleur.add(vert);
        couleur.add(bleu);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            Object o = e.getSource();
            Color clr;

            if (o == rouge) {
                clr = e.getStateChange() == 1 ? RED : WHITE;                
                panel.setBackground(clr);
            }
            else if (o == vert){
                clr = e.getStateChange() == 1 ? GREEN : WHITE;                
                panel.setBackground(clr);
            }
            else if (o == bleu){
                clr = e.getStateChange() == 1 ? BLUE : WHITE;                
                panel.setBackground(clr);
            }
    }

    public static void main(String[] args) {
        Exercice5 frame = new Exercice5("Test couleur");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


        
}


