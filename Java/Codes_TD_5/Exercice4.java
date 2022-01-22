import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Exercice4 extends JFrame implements ListSelectionListener, ActionListener{
 
    String tabLangProg[] = {"C", "C++", "Java", "Javascript", "HTML", "Python",
                            "PHP", "C#", "Ruby", "Chicken", "Batch", "Shell"};
    JList<String> JLLangProg;

    JPanel mainPanel, listePanel, dessinPanel;
    JButton valider;

    Exercice4(String nom){

        // Configuration de ma JFrame
        super(nom);

        // Panel principale qui va contenir deux autre panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        add(mainPanel);

        // Création du panel contenant la liste et le bouton
        listePanel = new JPanel();
        listePanel.setLayout(new BoxLayout(listePanel, BoxLayout.Y_AXIS));
        mainPanel.add(listePanel);

        // Création de la liste des langage de programmation
        JLLangProg = new JList<String>(tabLangProg);
        JLLangProg.addListSelectionListener(this);
        JLLangProg.setAlignmentX(Component.CENTER_ALIGNMENT);
        listePanel.add(JLLangProg);

        // Création du bouton valider
        valider = new JButton("Valider");
        valider.addActionListener(this);
        valider.setAlignmentX(Component.CENTER_ALIGNMENT);
        listePanel.add(valider);

        // Création de la zone de dessin
        dessinPanel = new JPanel();
        dessinPanel.setPreferredSize(new Dimension(250 , 250));
        dessinPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.add(dessinPanel);
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) { // empêche le double appuie

            dessinPanel.removeAll();
            dessinPanel.repaint();

            for (String lang : JLLangProg.getSelectedValuesList()) {
                JButton btn = new JButton(lang);
                dessinPanel.add(btn);
    
            }
            dessinPanel.validate();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        dessinPanel.removeAll();
        dessinPanel.repaint();

        for (String lang : JLLangProg.getSelectedValuesList()) {
            JButton btn = new JButton(lang);
            dessinPanel.add(btn);

        }
        dessinPanel.validate();
        
    }

    public static void main(String[] args) {
        Exercice4 f = new Exercice4("Langages de prog");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
