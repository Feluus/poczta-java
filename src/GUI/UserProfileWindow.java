package GUI;
import Utils.Utils;
import model.UserProfile;
import service.UserProfileService;

import javax.swing.*;
public class UserProfileWindow extends JFrame {
    private SendPackWindow sendPack;
    private FollowPackWindow follow;
    private MenuWindow menu;

    public static JTextField przyciskPoz = SendPackWindow.createTextField(290,227,234,15,"Jan");
    public static JTextField przyciskPoz2 = SendPackWindow.createTextField(290,321,234,15,"Kowalski");
    public static JTextField przyciskPoz3 = SendPackWindow.createTextField(290,414,234,15,"ul. Bęczkowska 12, Kielce");
    public static JTextField przyciskPoz4 = SendPackWindow.createTextField(290,507,234,15,"Numer telefonu");

    public void setSendPackWindow(SendPackWindow sendPack)
    {
        this.sendPack =sendPack;
    }

    UserProfileWindow(SendPackWindow SendPack,FollowPackWindow follow, MenuWindow menu,String loginUser){
        UserProfileService profileService = new UserProfileService();
        Utils util=new Utils();

        setTitle("Profil użytkownika");
        setSize(800, 820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);


        ImageIcon tlo = new ImageIcon(getClass().getResource("/resources/profiluzytkownika.jpg"));
        ImageIcon zapisz = new ImageIcon(getClass().getResource("/resources/historia.jpg"));
        ImageIcon wyloguj = new ImageIcon(getClass().getResource("/resources/wyloguj.jpg"));
        //ImageIcon avatarCzerw = new ImageIcon(getClass().getResource("/resources/avatarCzerw.jpg"));
        ImageIcon d = new ImageIcon(getClass().getResource("/resources/menukliknietev2.jpg"));


        JLabel background = new JLabel(tlo);
        JLabel zapiszButton = new JLabel(zapisz);
        JLabel wylogujButton= new JLabel(wyloguj);
       // JLabel avatarCzerwButton = new JLabel(avatarCzerw);
        JLabel menuKlikniete = new JLabel(d);


        background.setBounds(0, 0, 833, 847);
        background.setLayout(null);

        add(background);


        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
       // JButton avatar= SendPackWindow.createButton(385,59,67,89,"");
        //background.add(avatar);


        background.add(przyciskPoz);
        background.add(przyciskPoz2);
        background.add(przyciskPoz3);
        background.add(przyciskPoz4);
        UserProfile profile =
                profileService.getProfile(loginUser);

        if(profile != null) {

            przyciskPoz.setText(profile.firstName);
            przyciskPoz2.setText(profile.lastName);
            przyciskPoz3.setText(profile.address);
            przyciskPoz4.setText(profile.phone);
        }

        SendPackWindow.textListener(przyciskPoz, "Jan");
        SendPackWindow.textListener(przyciskPoz2, "Kowalski");
        SendPackWindow.textListener(przyciskPoz3, "ul. Bęczkowska 12, Kielce");
        SendPackWindow.textListener(przyciskPoz4, "Numer telefonu");

        util.maxTextLenght(przyciskPoz,20);
        util.maxTextLenght(przyciskPoz2,30);
        util.maxTextLenght(przyciskPoz3,80);
        util.maxTextLenghtPhone(przyciskPoz4,9);



        JButton przycisk = SendPackWindow.createButton(252,580,335,45,"");
        background.add(przycisk);
        SendPackWindow.placeBlady(249,573,350,55, zapiszButton);
        przycisk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

                UserProfile profile =
                        new UserProfile(
                                loginUser,
                                przyciskPoz.getText(),
                                przyciskPoz2.getText(),
                                przyciskPoz3.getText(),
                                przyciskPoz4.getText()
                        );

                profileService.saveProfile(profile);

                JOptionPane.showMessageDialog(
                        null,
                        "Zapisano zmiany"
                );
            }
        });
        background.add(zapiszButton);


        JButton przycisk2 = SendPackWindow.createButton(355,710,130,37,"");
        background.add(przycisk2);
        SendPackWindow.placeBlady(355,710,130,37,wylogujButton);
        przycisk2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

                przyciskPoz.setText( "Jan");
                przyciskPoz2.setText( "Kowalski");
                przyciskPoz3.setText( "ul. Bęczkowska 12, Kielce");
                przyciskPoz4.setText( "Numer telefonu");
                SendPack.setDefaultText();
                follow.codeField.setText("Wpisz numer paczki");
                follow.phonecodeField.setText("Wpisz numer telefonu");
                menu.setVisible(false);
                LoginWindow oknoLogin2 = new LoginWindow();
                oknoLogin2.setVisible(true);
                setVisible(false);
            }
        });
        background.add(wylogujButton);

        JButton przycisk3 = SendPackWindow.createButton(420,105,40,40,"");
        background.add(przycisk3);



        SendPackWindow.mouseListenerIMG(przycisk, zapiszButton);
        SendPackWindow.mouseListenerIMG(przycisk2, wylogujButton);


        JButton menuKliknieteButton = SendPackWindow.createButton(355, 649, 128, 39, "");
        background.add(menuKliknieteButton);
        SendPackWindow.placeBlady(340, 642, 160, 50, menuKlikniete);
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
