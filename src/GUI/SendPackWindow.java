package GUI;

import javax.swing.*;
import java.awt.Image;

public class SendPackWindow extends JFrame {
    public static JButton createButton(int x, int y, int width, int height, String tekst) {
        JButton button = new JButton(tekst);
        button.setBounds(x, y, width, height);

       // button.setBorder(null);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setVisible(true);

        return button;
    }
     public static JTextField createTextField(int x, int y, int width, int height) {
        JTextField fieldText= new JTextField();
         fieldText.setBounds(x, y, width, height);
         fieldText.setBorder(null);
         fieldText.setOpaque(false);
         fieldText.setVisible(true);

         //add(background);
         return fieldText;
     }
    public SendPackWindow() {
        setTitle("nadanie paczki");
        setSize(800, 820);
        setLayout(null);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo = new ImageIcon("src/resources/nadaj.jpg");


        Image img = tlo.getImage().getScaledInstance(800, 820, Image.SCALE_SMOOTH);
        ImageIcon scaledTlo = new ImageIcon(img);


        JLabel background = new JLabel(scaledTlo);
        background.setBounds(0, 0, 800, 790);
        background.setLayout(null);

        add(background);


        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });


        JButton przyciskGab = createButton(240,169,100,77,"");
        background.add(przyciskGab);
        JButton przyciskGab2 = createButton(350,169,100,77,"");
        background.add(przyciskGab2);
        JButton przyciskGab3 = createButton(460,169,100,77,"");
        background.add(przyciskGab3);

        JTextField przyciskPoz = createTextField(278,329,234,15);
        background.add(przyciskPoz);
        JTextField przyciskPoz2 = createTextField(278,388,234,15);
        background.add(przyciskPoz2);
        JTextField przyciskPoz3 = createTextField(278,444,234,15);
        background.add(przyciskPoz3);
        JTextField przyciskPoz4 = createTextField(278,504,234,15);
        background.add(przyciskPoz4);









    }
}