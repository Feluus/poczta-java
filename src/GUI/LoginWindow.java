package GUI;

import javax.swing.*;


public class LoginWindow extends JFrame {
    public LoginWindow(){


        setTitle("PocztaPolska");
        setSize(800,820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        ImageIcon tlo =new ImageIcon("src/resources/logowanie.jpg");
        ImageIcon pass2 =new ImageIcon("src/resources/password2.jpg");

        JLabel background = new JLabel(tlo);
        background.setBounds(0,0,790,785);
        background.setLayout(null);
        background.setVisible(true);
        add(background);
//tu
        JLabel password2 = new JLabel(pass2);
        password2.setBounds(237, 443, 319, 75);
        password2.setLayout(null);
        password2.setVisible(false);
        background.add(password2);


//dodac w przyszlosci domyslny text: wpisz login/wpisz haslo
        JTextField loginField = new JTextField();
        loginField.setBounds(270, 295, 300, 20);
        loginField.setBorder(null);
        loginField.setOpaque(false);
        background.add(loginField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(270, 397, 300, 20);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        background.add(passwordField);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(270, 482, 300, 20);
        passwordField2.setBorder(null);
        passwordField2.setOpaque(false);
        passwordField2.setVisible(false);
        background.add(passwordField2);


//przycisk login
        JButton loginButton = new JButton("");
        loginButton.setBounds(250, 530, 290, 40);
        loginButton.addActionListener(e -> {
            System.out.println("Kliknieto zaloguj");
        });
        loginButton.setBorder(null);
        loginButton.setOpaque(false);
        background.add(loginButton);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);

        //przycisk zaloz konto

        JButton registerButton = new JButton("");
        registerButton.setBounds(350, 595, 100, 30);
        registerButton.addActionListener(e -> {
            System.out.println("Kliknieto zaloz konto");

            password2.setVisible(true);
            passwordField2.setVisible(true);
            background.setComponentZOrder(passwordField2, 0);
            background.revalidate();
            background.repaint();



        });
        registerButton.setBorder(null);
        registerButton.setOpaque(false);
        background.add(registerButton);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);



    }

}
