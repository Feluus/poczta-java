package GUI;
import javax.swing.*;

public class PackHistory extends JFrame{

   public PackHistory(MenuWindow menu)
    {
        setTitle("Historia Twoich paczek");
        setSize(800,820);
        setLayout(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo =new ImageIcon(getClass().getResource("/resources/packhistory.jpg"));
        ImageIcon d = new ImageIcon(getClass().getResource("/resources/menukliknietev3.jpg"));
        ImageIcon e = new ImageIcon(getClass().getResource("/resources/reklamacjaklikniete.jpg"));

        JLabel background = new JLabel(tlo);
        JLabel menuKlikniete = new JLabel(d);
        JLabel reklamacjaKlikniete = new JLabel(e);

        background.setBounds(-40,-40,872,878);
        background.setLayout(null);
        add(background);
        background.setVisible(true);


        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });




        JButton reklamacjaKliknieteButton = SendPackWindow.createButton(333, 678, 220, 62, "");
        background.add(reklamacjaKliknieteButton);
        SendPackWindow.placeBlady(330, 671, 225, 70, reklamacjaKlikniete);
        SendPackWindow.mouseListenerIMG(reklamacjaKliknieteButton, reklamacjaKlikniete);
        reklamacjaKliknieteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("tutaj kiedys bedzie formularz reklamacyjny");
               // setVisible(false);
                //menu.setVisible(true);
            }
        });
        background.add(reklamacjaKlikniete);



        JButton menuKliknieteButton = SendPackWindow.createButton(360, 747, 168, 48, "");
        background.add(menuKliknieteButton);
        SendPackWindow.placeBlady(360, 747, 168, 48, menuKlikniete);
        SendPackWindow.mouseListenerIMG(menuKliknieteButton, menuKlikniete);
        menuKliknieteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                setVisible(false);
                menu.setVisible(true);
            }
        });
        background.add(menuKlikniete);
    }
}
