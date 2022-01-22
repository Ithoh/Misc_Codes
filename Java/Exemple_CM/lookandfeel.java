import javax.swing.*;
import java.awt.*;

class ListerLookAndFeel {
    public static void main(String args[]) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            UnsupportedLookAndFeelException {
        int i = 0;
        UIManager.LookAndFeelInfo lookAndFeelDispo[] = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lookAndFeel : lookAndFeelDispo) {
            UIManager.setLookAndFeel(lookAndFeel.getClassName());
            JFrame maFenetre = new JFrame(lookAndFeel.getName());
            maFenetre.setLocation(100 + i * 380, 100);
            i++;
            maFenetre.getContentPane().setLayout(new FlowLayout());
            maFenetre.add(new JButton("Bouton " + 1));
            maFenetre.add(new JRadioButton("Radio Bouton " + 2));
            maFenetre.add(new JCheckBox("Check box " + 3));
            maFenetre.pack();
            maFenetre.setVisible(true);
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}