package GUI;
import Utils.Utils;

import javax.swing.*;
public class FollowPackWindow extends JFrame{

    public static JTextField codeField = new JTextField("Wpisz numer paczki");

    public boolean isFirstClick=true;
    Utils util = new Utils();

    public FollowPackWindow(MenuWindow menu){
        setTitle("Śledzenie paczki");
        setSize(800,820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo =new ImageIcon(getClass().getResource("/resources/sledzenie.jpg"));
        ImageIcon sledz3 =new ImageIcon(getClass().getResource("/resources/sledz3.jpg"));
        ImageIcon d = new ImageIcon(getClass().getResource("/resources/menuklikniete.jpg"));

        JLabel background = new JLabel(tlo);
        JLabel followButton2 = new JLabel(sledz3);
        JLabel menuKlikniete = new JLabel(d);

        background.setBounds(-40,0,872,878);
        background.setLayout(null);
        background.setVisible(true);

        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });




//pole wpisania kodu

        codeField.setBounds(313, 230, 270, 20);
        codeField.setBorder(null);
        codeField.setOpaque(false);
        codeField.setVisible(true);
        background.add(codeField);
        codeField.setFocusable(false);
        util.maxTextLenghtPhone(codeField, 9);
        codeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                codeField.setFocusable(true);
                codeField.requestFocusInWindow();
                            }
        });

        codeField.addFocusListener(new java.awt.event.FocusAdapter() {


            public void focusGained(java.awt.event.FocusEvent e) {


                if(codeField.getText().equals("Wpisz numer paczki")) {

                    codeField.setText("");


                }

            }

            public void focusLost(java.awt.event.FocusEvent e) {

                if(codeField.getText().isEmpty()) {
                    codeField.setText("Wpisz numer paczki");
                }

            }


        });

        add(background);

//sledz przycisk
        JButton followButton = new JButton();
        followButton.setBounds(264, 304, 345, 60);
        followButton2.setBounds(255, 300, 361, 70);
        followButton.addActionListener(e -> {
            System.out.println("Kliknieto sledz");
            JOptionPane.showMessageDialog(
                    null,
                    "Nie ma takiej paczki w bazie",
                    "Błąd wyszukiwania",
                    JOptionPane.ERROR_MESSAGE
            );
        });
        followButton.setBorder(null);
        followButton.setOpaque(false);
        background.add(followButton);
        background.add(followButton2);
        followButton2.setVisible(false);
        followButton.setContentAreaFilled(false);
        followButton.setFocusPainted(false);

        followButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                followButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                followButton2.setVisible(false);
            }
        });



        JButton menuKliknieteButton = SendPackWindow.createButton(364, 390, 147, 39, "");
        background.add(menuKliknieteButton);
        SendPackWindow.placeBlady(338, 380, 200, 73, menuKlikniete);
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
