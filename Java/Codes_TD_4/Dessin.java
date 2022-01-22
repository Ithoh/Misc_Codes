import java.awt.*;
import javax.swing.*;

public class Dessin extends JFrame {

    public void paint(Graphics g) {
        super.paint(g);

        float tailleCoteFenetre = (float) (Math.min(getWidth(), getHeight()));
        float tailleCote = tailleCoteFenetre / 2;
        float xCoinGauche = tailleCote / 2;
        float yCoinGauche = tailleCote / 2;
        g.setColor(Color.WHITE);

        g.drawRect((int) xCoinGauche, (int) yCoinGauche, (int) tailleCote, (int) tailleCote);
        g.drawLine((int) xCoinGauche, (int) yCoinGauche, (int) (xCoinGauche + tailleCote),
                (int) (yCoinGauche + tailleCote));
        g.drawLine((int) xCoinGauche, (int) (yCoinGauche + tailleCote), (int) (xCoinGauche + tailleCote),
                (int) yCoinGauche);

    }

    public static void main(String[] args) {

        Dessin f = new Dessin();

        f.setTitle("Dessin");
        f.getContentPane().setBackground(Color.darkGray);
        f.setSize(new Dimension(300, 300));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
