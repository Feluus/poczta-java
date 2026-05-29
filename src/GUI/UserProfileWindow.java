package GUI;
import javax.swing.*;
public class UserProfileWindow extends JFrame {
    UserProfileWindow(){
        setTitle("nadanie paczki");
        setSize(800, 820);
        setLayout(null);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo = new ImageIcon("src/resources/profiluzytkownika.jpg");
        ImageIcon historia = new ImageIcon("src/resources/historia.jpg");
        ImageIcon wyloguj = new ImageIcon("src/resources/wyloguj.jpg");
        ImageIcon avatarCzerw = new ImageIcon("src/resources/avatarCzerw.jpg");


        JLabel background = new JLabel(tlo);
        JLabel historiaButton = new JLabel(historia);
        JLabel wylogujButton= new JLabel(wyloguj);
        JLabel avatarCzerwButton = new JLabel(avatarCzerw);


        background.setBounds(0, 0, 833, 847);
        background.setLayout(null);

        add(background);


        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
        JButton avatar= SendPackWindow.createButton(385,59,67,89,"");
        background.add(avatar);

        JTextField przyciskPoz = SendPackWindow.createTextField(290,227,234,15,"Jan");
        background.add(przyciskPoz);
        JTextField przyciskPoz2 = SendPackWindow.createTextField(290,321,234,15,"Kowalski");
        background.add(przyciskPoz2);
        JTextField przyciskPoz3 = SendPackWindow.createTextField(290,414,234,15,"ul. Bęczkowska 12, Kielce");
        background.add(przyciskPoz3);
        JTextField przyciskPoz4 = SendPackWindow.createTextField(290,507,234,15,"000-000-000");
        background.add(przyciskPoz4);

        SendPackWindow.textListener(przyciskPoz, "Jan");
        SendPackWindow.textListener(przyciskPoz2, "Kowalski");
        SendPackWindow.textListener(przyciskPoz3, "ul. Bęczkowska 12, Kielce");
        SendPackWindow.textListener(przyciskPoz4, "000-000-000");



        JButton przycisk = SendPackWindow.createButton(255,580,325,45,"");
        background.add(przycisk);
        SendPackWindow.placeBlady(251,578,345,50, historiaButton);
        background.add(historiaButton);

        JButton przycisk2 = SendPackWindow.createButton(355,710,130,37,"");
        background.add(przycisk2);
        SendPackWindow.placeBlady(355,710,130,37,wylogujButton);
        background.add(wylogujButton);

        JButton przycisk3 = SendPackWindow.createButton(420,105,40,40,"");
        background.add(przycisk3);


        SendPackWindow.placeBlady(432,118,32,32, avatarCzerwButton);
        background.add(avatarCzerwButton);


        SendPackWindow.mouseListenerIMG(przycisk, historiaButton);
        SendPackWindow.mouseListenerIMG(przycisk2, wylogujButton);
        SendPackWindow.mouseListenerIMG(przycisk3, avatarCzerwButton);



    }

}
