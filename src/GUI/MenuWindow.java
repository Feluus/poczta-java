package GUI;

import javax.swing.*;

public class MenuWindow extends JFrame{
    public MenuWindow(){
        FollowPackWindow follow = new FollowPackWindow();
        SendPackWindow SendPack = new SendPackWindow();
        UserProfileWindow UserProfile = new UserProfileWindow();

    setTitle("PocztaPolska");
    setSize(800,820);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

        ImageIcon tlo =new ImageIcon("src/resources/menu.jpg");
        JLabel background = new JLabel(tlo);
        background.setBounds(-50,0,900,900);
        background.setLayout(null);
        background.setVisible(true);
        background.addMouseListener(new java.awt.event.MouseAdapter() {  // <----- listener
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
        add(background);
//przycisk wyslij paczke
        JButton sendPackButton = new JButton("");
        sendPackButton.setBounds(235, 215, 430, 95);
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
        followButton.setBounds(235, 337, 430, 95);
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
        profileButton.setBounds(235, 459, 430, 95);
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
        packsButton.setBounds(600, 645, 55, 50);
        packsButton.addActionListener(e -> {
            System.out.println("Kliknieto paczki");
        });
        packsButton.setBorder(null);
        packsButton.setOpaque(false);
        background.add(packsButton);
        packsButton.setContentAreaFilled(false);
        packsButton.setFocusPainted(false);


}}
