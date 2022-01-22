import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static java.lang.System.out;


public class CalculPI extends JPanel implements ActionListener, ItemListener {
    
    Integer increments[] = {1,10,50,100,200,500,1000,2000,5000};

    Color bg = new Color(33, 33 ,33);

    JLabel afficherNbrGrain = new JLabel("Avec 1 grains de riz");
    JLabel afficherApproxPI = new JLabel("Pi : 3.14159");
    JPanel comboEtBtn = new JPanel();
    JComboBox<Integer> nbrIncrements = new JComboBox<Integer>(increments);
    JButton estimationBtn = new JButton("Estimation de PI");
    JPanel dessin = new JPanel();
    JButton effacer = new JButton("Effacer");
    Graphics g;

    CalculPI(){
        // Taille de la fenetre
        setPreferredSize(new Dimension(500, 600));
        // On change le layout pour une list verticale
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // On aligne les labels
        afficherNbrGrain.setAlignmentX(Component.CENTER_ALIGNMENT);
        afficherApproxPI.setAlignmentX(Component.CENTER_ALIGNMENT);
        // On ajoute les labels au panel
        add(afficherNbrGrain);
        add(afficherApproxPI);

        // Ajout du listener
        nbrIncrements.addItemListener(this);
        // Ajout du listener sur le btn
        estimationBtn.addActionListener(this);

        comboEtBtn.add(nbrIncrements);
        comboEtBtn.add(estimationBtn);
        // On ajoute le panel contenant la combo box et le btn
        add(comboEtBtn);
        dessin.setPreferredSize(new Dimension(500, 500));
        g = dessin.getGraphics();

        dessin.setBackground(bg);
        
        g.drawOval(0, 0, 100, 100);

        // on ajoute la zone de dessin
        add(dessin);
        // on ajoute le btn effacer
        effacer.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(effacer);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        out.println("Ya eu une action");
        Object obj = e.getSource();

        if(obj == estimationBtn){
            out.println("ya eu un truc sur le btn estimation");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();

        if (obj == nbrIncrements) {
            afficherNbrGrain.setText("Avec " + e.getItem() + " grains de riz");
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }


    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Estimation de pi");
        fenetre.setContentPane(new CalculPI());
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();

    }
}