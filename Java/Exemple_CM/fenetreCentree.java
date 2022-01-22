import javax.swing.*;
import java.awt.*;

class MaFenetreCentree extends JFrame {
    public MaFenetreCentree(String titre) {
        setTitle(titre);
        getContentPane().setBackground(Color.RED);
        int taille = 500;
        setPreferredSize(new Dimension(taille, taille));
        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((dimEcran.width - taille) / 2,
                (dimEcran.height - taille) / 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

class JFrameHeritage {
    public static void main(String args[]) {
        MaFenetreCentree fc = new MaFenetreCentree(args[0]);
    }
}