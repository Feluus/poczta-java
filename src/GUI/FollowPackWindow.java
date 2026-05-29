package GUI;
import javax.swing.*;
public class FollowPackWindow extends JFrame{

    public boolean isFirstClick=true;

    public FollowPackWindow(){
        setTitle("Śledzenie paczki");
        setSize(800,820);
        setLayout(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo =new ImageIcon("src/resources/sledzenie.jpg");
        ImageIcon sledz3 =new ImageIcon("src/resources/sledz3.jpg");

        JLabel background = new JLabel(tlo);
        JLabel followButton2 = new JLabel(sledz3);

        background.setBounds(-40,0,872,878);
        background.setLayout(null);
        background.setVisible(true);

        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });




//pole wpisania kodu
        JTextField loginField = new JTextField("Wpisz numer paczki");
        loginField.setBounds(313, 230, 270, 20);
        loginField.setBorder(null);
        loginField.setOpaque(false);
        loginField.setVisible(true);
        background.add(loginField);
        loginField.setFocusable(false);
        loginField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                loginField.setFocusable(true);
                loginField.requestFocusInWindow();

            }
        });

        loginField.addFocusListener(new java.awt.event.FocusAdapter() {


            public void focusGained(java.awt.event.FocusEvent e) {


                if(loginField.getText().equals("Wpisz numer paczki")) {

                    loginField.setText("");

                }

            }

            public void focusLost(java.awt.event.FocusEvent e) {

                if(loginField.getText().isEmpty()) {
                    loginField.setText("Wpisz numer paczki");
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



    }
}
