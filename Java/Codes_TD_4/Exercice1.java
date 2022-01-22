import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Exercice1 extends JPanel implements MouseListener {
    
    Exercice1(){
        addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("La souris est clickée");
        System.out.println("X : " + e.getX() + " Y : " + e.getY());
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("La souris est entrée dans le pannel");
        System.out.println("X : " + e.getX() + " Y : " + e.getY());
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("La souris est sortie du pannel");
        System.out.println("X : " + e.getX() + " Y : " + e.getY());
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("La souris est pressée");
        System.out.println("X : " + e.getX() + " Y : " + e.getY());
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("La souris est relachée");
        System.out.println("X : " + e.getX() + " Y : " + e.getY());
        
    }


    public static void main(String[] args) {

        JFrame fenetre = new JFrame();

        fenetre.setTitle("Test event");
        fenetre.setSize(new Dimension(600, 600));
        fenetre.setContentPane(new Exercice1());
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
