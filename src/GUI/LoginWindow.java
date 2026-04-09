package GUI;

import javax.swing.*;
import java.awt.*;


public class LoginWindow extends JFrame {
    public boolean isLogginScreen = true;
    public boolean isRegisterScreen = false;

    public LoginWindow() {


        setTitle("PocztaPolska");
        setSize(800, 820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        ImageIcon tlo = new ImageIcon("src/resources/logowanie.jpg");
        ImageIcon pass2 = new ImageIcon("src/resources/password2.jpg");
        ImageIcon przycisk2 = new ImageIcon("src/resources/loginButton2.jpg");
        ImageIcon przycisk3 = new ImageIcon("src/resources/registerButton2.jpg");


        JLabel background = new JLabel(tlo);
        background.setBounds(0, 0, 790, 785);
        background.setLayout(null);
        background.setVisible(true);
        add(background);
//tu
        JLabel password2 = new JLabel(pass2);
        password2.setBounds(238, 425, 319, 75);
        password2.setLayout(null);
        password2.setVisible(false);
        background.add(password2);
//blady login
        JLabel loginButton2 = new JLabel(przycisk2);
        loginButton2.setBounds(238, 506, 322, 56);
        loginButton2.setLayout(null);
        background.add(loginButton2);
        loginButton2.setVisible(false);


        //blady register
        JLabel registerButton2 = new JLabel(przycisk3);
        registerButton2.setBounds(345, 570, 100, 30);
        registerButton2.setLayout(null);
        background.add(registerButton2);
        registerButton2.setVisible(false);

//dodac w przyszlosci domyslny text: wpisz login/wpisz haslo
        JTextField loginField = new JTextField();
        loginField.setBounds(277, 285, 300, 20);
        loginField.setBorder(null);
        loginField.setOpaque(false);
        background.add(loginField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(277, 382, 300, 20);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        background.add(passwordField);

        JPasswordField passwordField2 = new JPasswordField();
        passwordField2.setBounds(277, 462, 300, 20);
        passwordField2.setBorder(null);
        passwordField2.setOpaque(false);
        passwordField2.setVisible(false);
        background.add(passwordField2);


//przycisk login
        JButton loginButton = new JButton("");
        loginButton.setBounds(244, 508, 302, 45);

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setOpaque(false);
                loginButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton2.setVisible(false);
            }
        });

        loginButton.addActionListener(e -> {
            System.out.println("Kliknieto zaloguj");
        });
        loginButton.setBorder(null);
        loginButton.setOpaque(false);
        background.add(loginButton);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);

        //nakladka na login

        JLabel hideLogin = new JLabel();
        hideLogin.setBounds(230, 500, 320, 70);
        hideLogin.setOpaque(true);
        hideLogin.setVisible(false);
        hideLogin.setBorder(null);
        hideLogin.setBackground(Color.WHITE);
        background.add(hideLogin);

        //przycisk zaloz konto

        JButton registerButton = new JButton("");
        registerButton.setBounds(345, 570, 100, 30);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                registerButton2.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton2.setVisible(false);
            }
        });


            registerButton.addActionListener(e -> {
                if (isRegisterScreen == false) {
                    System.out.println("Kliknieto zaloz konto");

                    password2.setVisible(true);
                    passwordField2.setVisible(true);
                    background.setComponentZOrder(passwordField2, 0);
                    background.revalidate();
                    background.repaint();


                    loginButton.setVisible(false);
                    hideLogin.setVisible(true);

                    isLogginScreen = false;
                    isRegisterScreen = true;
                }else
                {
                    System.out.println("Kliknieto zaloz konto");

                    password2.setVisible(false);
                    passwordField2.setVisible(false);
                    // background.setComponentZOrder(passwordField2, 0);
                    //background.revalidate();
                    //background.repaint();


                    loginButton.setVisible(true);
                    hideLogin.setVisible(false);

                    isLogginScreen = true;
                    isRegisterScreen = false;


                }


            });


            registerButton.setBorder(null);
            registerButton.setOpaque(false);
            background.add(registerButton);
            registerButton.setContentAreaFilled(false);
            registerButton.setFocusPainted(false);


        }

    }

