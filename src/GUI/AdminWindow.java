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
        ImageIcon wyloguj = new ImageIcon(getClass().getResource("/resources/wylogujniebieski.jpg"));
        ImageIcon dodaj = new ImageIcon(getClass().getResource("/resources/dodajblady.jpg"));
        ImageIcon usun = new ImageIcon(getClass().getResource("/resources/usunblady.jpg"));



        JLabel background = new JLabel(scaledTlo);
        JLabel wylogujButton= new JLabel(wyloguj);
        JLabel dodajButton = new JLabel(dodaj);
        JLabel usunButton = new JLabel(usun);

        background.setBounds(-30,0,848,820);
        background.setLayout(null);
        background.setVisible(true);
        add(background);

        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });





        JButton usunPrzycisk = SendPackWindow.createButton(550,40,120,40,"");
        SendPackWindow.mouseListenerIMG(usunPrzycisk, usunButton);
        background.add(usunPrzycisk);
        SendPackWindow.placeBlady(537,29,140,60,usunButton);
        usunPrzycisk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("kliknieto usun");

            }
        });
        background.add(usunButton);



        JButton przycisk2 = SendPackWindow.createButton(338,704,168,52,"");
        SendPackWindow.mouseListenerIMG(przycisk2, wylogujButton);
        background.add(przycisk2);
        SendPackWindow.placeBlady(339,704,168,50,wylogujButton);
        przycisk2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

            setVisible(false);
            //login.setVisible(true);
            }
        });
        background.add(wylogujButton);





        JButton dodajPrzycisk = SendPackWindow.createButton(682,40,104,40,"");
        SendPackWindow.mouseListenerIMG(dodajPrzycisk, dodajButton);
        background.add(dodajPrzycisk);
        SendPackWindow.placeBlady(680,37,115,52,dodajButton);
        dodajPrzycisk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

            }
        });
        background.add(dodajButton);

    }
}
