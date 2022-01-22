import javax.swing.*;
import java.awt.*;

class MaPremiereFenetre {
    public static void main(String args[]) {
        JFrame maFenetre = new JFrame("Hello World !");
        maFenetre.setBounds(100, // abs
                400, // ord
                600, // larg
                300); // long
        maFenetre.setVisible(true);
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.getContentPane().setLayout(new FlowLayout());
        maFenetre.add(new JButton("Bouton " + 1));
        maFenetre.add(new JRadioButton("Radio Bouton " + 2));
        maFenetre.add(new JCheckBox("Check box " + 3));
        maFenetre.pack();
    }
}
