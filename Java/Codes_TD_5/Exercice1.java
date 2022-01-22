import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Exercice1 extends MouseAdapter{
    
    public void mousePressed(MouseEvent e){
        System.out.println("Clique souris, X : " + e.getX() + " Y : " + e.getY());
    }

    public void mouseReleased(MouseEvent e){
        System.out.println("Relachement souris, X : " + e.getX() + " Y : " + e.getY());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Detecteur de clique de souris");
        frame.addMouseListener(new Exercice1());
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
