package GUI;
import Utils.Utils;
import model.PackageData;
import service.PackageService;

import javax.swing.*;
public class FollowPackWindow extends JFrame{
    PackageService packageService = new PackageService();

    public static JTextField codeField = new JTextField("Wpisz numer paczki");
    public static JTextField phonecodeField = new JTextField("Wpisz numer telefonu");

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
        util.maxTextLenght(codeField, 8);
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


        //pole telefonu

        phonecodeField.setBounds(313, 328, 270, 20);
        phonecodeField.setBorder(null);
        phonecodeField.setOpaque(false);
        phonecodeField.setVisible(true);
        background.add( phonecodeField);
        phonecodeField.setFocusable(false);
        util.maxTextLenghtPhone( phonecodeField, 9);
        phonecodeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                phonecodeField.setFocusable(true);
                phonecodeField.requestFocusInWindow();
            }
        });

        phonecodeField.addFocusListener(new java.awt.event.FocusAdapter() {


            public void focusGained(java.awt.event.FocusEvent e) {


                if( phonecodeField.getText().equals("Wpisz numer telefonu")) {

                    phonecodeField.setText("");


                }

            }

            public void focusLost(java.awt.event.FocusEvent e) {

                if( phonecodeField.getText().isEmpty()) {
                    phonecodeField.setText("Wpisz numer telefonu");
                }

            }


        });

        add(background);

//sledz przycisk
        JButton followButton = new JButton();
        followButton.setBounds(264, 394, 345, 60);
        followButton2.setBounds(255, 390, 361, 70);
        followButton.addActionListener(e -> {

            packageService.loadPackagesFromFile();
            String code = codeField.getText();
            String phone = phonecodeField.getText();
            PackageData p = packageService.findPackage(code, phone);

            if(p != null)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Status paczki:\n\n" + p.status,
                        "Śledzenie przesyłki",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            else
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Nie ma takiej paczki w bazie",
                        "Błąd wyszukiwania",
                        JOptionPane.ERROR_MESSAGE
                );
            }
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



        JButton menuKliknieteButton = SendPackWindow.createButton(362, 485, 147, 39, "");
        background.add(menuKliknieteButton);
        SendPackWindow.placeBlady(338, 470, 200, 73, menuKlikniete);
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
