package GUI;

import Utils.Utils;
import model.User;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginWindow extends JFrame {

    public boolean isLogginScreen = true;
    public boolean isRegisterScreen = false;
    UserService uS = new UserService();

    Utils utils= new Utils();

    public String login,password;



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
        background.setBounds(0, -5, 790, 785);
        background.setLayout(null);
        background.setVisible(true);
        add(background);

        JLabel password2 = new JLabel(pass2);
        password2.setBounds(242, 443, 319, 75);
        password2.setLayout(null);
        password2.setVisible(false);
        background.add(password2);
//blady login
        JLabel loginButton2 = new JLabel(przycisk2);
        loginButton2.setBounds(235, 494, 322, 56);
        loginButton2.setLayout(null);
        background.add(loginButton2);
        loginButton2.setVisible(false);


        //blady register
        JLabel registerButton2 = new JLabel(przycisk3);
        registerButton2.setBounds(344, 560, 100, 30);
        registerButton2.setLayout(null);
        background.add(registerButton2);
        registerButton2.setVisible(false);


        JTextField loginField = new JTextField("Wpisz login");
        JPasswordField passwordField = new JPasswordField("Wpisz haslo");
        JPasswordField passwordField2 = new JPasswordField("Wpisz halso");

        loginField.setBounds(278, 281, 300, 20);
        loginField.setBorder(null);
        loginField.setOpaque(false);
        loginField.addActionListener(e -> {
            login = loginField.getText();
            System.out.println(login);
            passwordField.requestFocusInWindow();

        });
        background.add(loginField);


        passwordField.setBounds(279, 378, 300, 20);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordField.addActionListener(e -> {
            password = passwordField.getText();
            System.out.println(password);
        });
        background.add(passwordField);


        passwordField2.setBounds(281, 480, 300, 20);
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
//logowanie
        if (isLogginScreen){
            loginButton.addActionListener(e -> {
                login = loginField.getText();
                password = passwordField.getText();
                if(uS.logging(login, password))
                {
                    setVisible(false);
                    MenuWindow menu = new MenuWindow(login);
                    menu.setVisible(true);



                }else
                {
                    JOptionPane.showMessageDialog(
                            this,
                            "Nieprawidłowy login lub hasło",
                            "Błąd logowania",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
    }

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

//tu2
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

                    loginField.setText("Wpisz login");
                    passwordField.setText("Wpisz haslo");
                    passwordField2.setText("Wpisz halso");
                    isLogginScreen = false;
                    isRegisterScreen = true;

                }else
                {
                    System.out.println("Kliknieto zaloz konto");
                   String login = loginField.getText();
                   String password = passwordField.getText();
                   String passwordToCheck = passwordField2.getText();
                   if(password.equals(passwordToCheck))
                   {
                       uS.register(login, password);
                       password2.setVisible(false);
                       passwordField2.setVisible(false);
                       loginButton.setVisible(true);
                       hideLogin.setVisible(false);
                       isLogginScreen = true;
                       isRegisterScreen = false;
                       loginField.setText("Wpisz login");
                       passwordField.setText("Wpisz haslo");


                   }
                   else
                   {
                       JOptionPane.showMessageDialog(
                               this,
                               "Hasła się nie zgadzają",
                               "Błąd rejestracji",
                               JOptionPane.ERROR_MESSAGE
                       );
                       loginField.setText("Wpisz login");
                       passwordField.setText("Wpisz haslo");
                       passwordField2.setText("Wpisz halso");


                   }

                    // background.setComponentZOrder(passwordField2, 0);
                    //background.revalidate();
                    //background.repaint();
                }


            });

       utils.maxTextLenght(loginField,24);
        utils.maxTextLenght(passwordField,24);
        utils.maxTextLenght(passwordField2,24);

            registerButton.setBorder(null);
            registerButton.setOpaque(false);
            background.add(registerButton);
            registerButton.setContentAreaFilled(false);
            registerButton.setFocusPainted(false);


        SendPackWindow.textListener(loginField,"Wpisz login");
        SendPackWindow.textListener(passwordField,"Wpisz haslo");
        SendPackWindow.textListener(passwordField2,"Wpisz halso");
//komunikaty

        }

    }

