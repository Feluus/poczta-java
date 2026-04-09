package GUI;
import javax.swing.*;
public class FollowPackWindow extends JFrame{

    public FollowPackWindow(){
        setTitle("Śledzenie paczki");
        setSize(800,820);
        setLayout(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo =new ImageIcon("src/resources/sledzenie.jpg");
        JLabel background = new JLabel(tlo);
        background.setBounds(-40,0,872,878);
        background.setLayout(null);
        background.setVisible(true);

        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
//pole wpisania kodu
        JTextField loginField = new JTextField();
        loginField.setBounds(313, 230, 270, 20);
        loginField.setBorder(null);
        loginField.setOpaque(false);
        loginField.setVisible(true);
        background.add(loginField);
        add(background);
//sledz przycisk
        JButton followButton = new JButton("");
        followButton.setBounds(264, 304, 345, 60);
        followButton.addActionListener(e -> {
            System.out.println("Kliknieto sledz");
        });
        followButton.setBorder(null);
        followButton.setOpaque(false);
        background.add(followButton);
        followButton.setContentAreaFilled(false);
        followButton.setFocusPainted(false);


    }
}
