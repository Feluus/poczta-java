package GUI;

import model.User;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame{
    public MenuWindow(String loginName){
        FollowPackWindow follow = new FollowPackWindow();
        SendPackWindow SendPack = new SendPackWindow();
        UserProfileWindow UserProfile = new UserProfileWindow();



    setTitle("PocztaPolska");
    setSize(800,820);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

        ImageIcon tlo =new ImageIcon("src/resources/menu.jpg");
        ImageIcon nadaj =new ImageIcon("src/resources/nadaj2.jpg");
        ImageIcon sledz =new ImageIcon("src/resources/sledz2.jpg");
        ImageIcon profil =new ImageIcon("src/resources/profil2.jpg");
        ImageIcon maly =new ImageIcon("src/resources/maly2.jpg");

        JLabel background = new JLabel(tlo);
        JLabel sendPackButton2 = new JLabel(nadaj);
        JLabel followButton2 = new JLabel(sledz);
        JLabel profileButton2 = new JLabel(profil);
        JLabel packsButton2 = new JLabel(maly);
        JLabel welcomeLabel = new JLabel(loginName);








        background.setBounds(0, 0, 800, 820);
        background.setLayout(null);
        background.setVisible(true);
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
        add(background);

        background.add(sendPackButton2);
        background.add(followButton2);
        background.add(profileButton2);
        background.add(packsButton2);

        sendPackButton2.setVisible(false);
        followButton2.setVisible(false);
        profileButton2.setVisible(false);
        packsButton2.setVisible(false);




        //przycisk wyslij paczke
        JButton sendPackButton = new JButton("");
        sendPackButton.setBounds(212, 184, 377, 84);
        sendPackButton2.setBounds(193, 177, 410, 100);
        sendPackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendPackButton.setOpaque(false);
                sendPackButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendPackButton2.setVisible(false);
            }
        });

        sendPackButton.addActionListener(e -> {
            System.out.println("Kliknieto nadaj");
            SendPack.setVisible(true);

        });

        sendPackButton.setBorder(null);
        sendPackButton.setOpaque(false);
        background.add(sendPackButton);
        sendPackButton.setContentAreaFilled(false);
        sendPackButton.setFocusPainted(false);

        //przycisk sledz
        JButton followButton = new JButton("");
        followButton.setBounds(212, 291, 377, 84);
        followButton2.setBounds(193, 284, 410, 100);
        followButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                followButton.setOpaque(false);
                followButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                followButton2.setVisible(false);
            }
        });
        followButton.addActionListener(e -> {
            System.out.println("Kliknieto sledz");
            follow.setVisible(true);

        });
        followButton.setBorder(null);
        followButton.setOpaque(false);
        background.add(followButton);
        followButton.setContentAreaFilled(false);
        followButton.setFocusPainted(false);

        //przycisk profil uzytkownika
        JButton profileButton = new JButton("");
        profileButton.setBounds(212, 398, 377, 84);
        profileButton2.setBounds(193, 390, 410, 100);
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileButton.setOpaque(false);
                profileButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileButton2.setVisible(false);
            }
        });
        profileButton.addActionListener(e -> {
            System.out.println("Kliknieto profil uzytkownika");
            UserProfile.setVisible(true);

        });
        profileButton.setBorder(null);
        profileButton.setOpaque(false);
        background.add(profileButton);
        profileButton.setContentAreaFilled(false);
        profileButton.setFocusPainted(false);

        JButton packsButton = new JButton("");
        packsButton.setBounds(533, 559, 47, 50);
        packsButton2.setBounds(530, 559, 54, 50);
        packsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                packsButton.setOpaque(false);
                packsButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                packsButton2.setVisible(false);
            }
        });
        packsButton.addActionListener(e -> {
            System.out.println("Kliknieto paczki");
        });
        packsButton.setBorder(null);
        packsButton.setOpaque(false);
        background.add(packsButton);
        packsButton.setContentAreaFilled(false);
        packsButton.setFocusPainted(false);



        /*void welcomeLabelMova(loginName.getLenght())
        {
przesuniecie o dlugosc !!! jutro zrobic
        }
*/

        welcomeLabel.setBounds(375, 136, 160, 40);
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        background.add(welcomeLabel);
        welcomeLabel.setVisible(true);




}}
