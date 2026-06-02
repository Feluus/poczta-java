package GUI;

import javax.swing.*;
import java.awt.*;

public class AdminWindow extends JFrame {

    public AdminWindow(){
        setTitle("Panel Admina");
        setSize(800,820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo = new ImageIcon(
                getClass().getResource("/resources/adminTlo.jpg")
        );

        Image img = tlo.getImage().getScaledInstance(
                getWidth(),
                getHeight(),
                java.awt.Image.SCALE_SMOOTH
        );

        ImageIcon scaledTlo = new ImageIcon(img);

        JLabel background = new JLabel(scaledTlo);
        background.setBounds(-30,0,848,820);
        background.setLayout(null);
        background.setVisible(true);
        add(background);

        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });

    }
}
