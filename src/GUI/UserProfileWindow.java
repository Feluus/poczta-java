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
        JLabel background = new JLabel(tlo);
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

        JTextField przyciskPoz = SendPackWindow.createTextField(290,228,234,15);
        background.add(przyciskPoz);
        JTextField przyciskPoz2 = SendPackWindow.createTextField(290,322,234,15);
        background.add(przyciskPoz2);
        JTextField przyciskPoz3 = SendPackWindow.createTextField(290,415,234,15);
        background.add(przyciskPoz3);
        JTextField przyciskPoz4 = SendPackWindow.createTextField(290,508,234,15);
        background.add(przyciskPoz4);

        JButton przycisk = SendPackWindow.createButton(255,580,325,45,"");
        background.add(przycisk);
        JButton przycisk2 = SendPackWindow.createButton(355,710,130,37,"");
        background.add(przycisk2);


    }

}
