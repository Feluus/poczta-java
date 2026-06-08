package GUI;

import Utils.Utils;
import model.PackageData;
import service.PackageService;

import javax.swing.*;
import java.awt.Image;

public class SendPackWindow extends JFrame {
   public static boolean isClicked =false;
    Utils util = new Utils();

    PackageService packageService;

    public static JLabel selectedLabel = null;
    public static String selectedSize = "";

    public static JTextField przyciskPoz = createTextField(278, 329, 234, 15, "Imię i Nazwisko");
    public static JTextField przyciskPoz2 = createTextField(278, 388, 234, 15, "Miejscowość");
    public static JTextField przyciskPoz3 = createTextField(278, 444, 234, 15, "Ulica, numer budynku/mieszkania");
    public static JTextField przyciskPoz4 = createTextField(278, 504, 234, 15, "Numer telefonu");


    public static void clickListener(JButton buttonTitle, JLabel buttonTitle2,String size) {


        buttonTitle.addActionListener(e -> {

            if(selectedLabel != null) {
                selectedLabel.setVisible(false);
            }

            buttonTitle2.setVisible(true);
            selectedLabel = buttonTitle2;
           selectedSize = size;

        });


    }

    public static void textListener(JTextField buttonTitle, String text) {

        buttonTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                buttonTitle.setFocusable(true);
                buttonTitle.requestFocusInWindow();

            }
        });
        buttonTitle.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusGained(java.awt.event.FocusEvent e) {

                if(buttonTitle.getText().equals(text))
                {
                    buttonTitle.setText("");
                }

            }

            public void focusLost(java.awt.event.FocusEvent e) {

                if(buttonTitle.getText().equals(""))
                {
                    buttonTitle.setText(text);
                }

            }
        });


    }

    public static void mouseListenerIMG(JButton buttonTitle, JLabel image) {


        buttonTitle.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {


                image.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                image.setVisible(false);
            }
        });


    }
    public static JButton createButton(int x, int y, int width, int height, String tekst) {
        JButton button = new JButton(tekst);
        button.setBounds(x, y, width, height);

       button.setBorder(null);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setVisible(true);

        return button;
    }
     public static JTextField createTextField(int x, int y, int width, int height, String text) {
        JTextField fieldText= new JTextField();
         fieldText.setBounds(x, y, width, height);
         fieldText.setText(text);
         fieldText.setBorder(null);
         fieldText.setOpaque(false);
         fieldText.setVisible(true);

         //add(background);
         return fieldText;
     }

    public static void placeBlady(int x, int y, int width, int height,JLabel name) {

        name.setBounds(x, y, width, height);
        name.setBorder(null);
        name.setOpaque(false);
        name.setVisible(false);


    }
    public static void setDefaultText()
    {
        przyciskPoz.setText( "Imię i Nazwisko");
        przyciskPoz2.setText( "Miejscowość");
        przyciskPoz3.setText( "Ulica, numer budynku/mieszkania");
        przyciskPoz4.setText( "Numer telefonu");
        selectedSize = "";
        selectedLabel = null;
    }



    public SendPackWindow(MenuWindow menu, UserProfileWindow profile, String loginUser) {
        setTitle("nadanie paczki");
        setSize(800, 820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        packageService = new PackageService();

        ImageIcon tlo = new ImageIcon(getClass().getResource("/resources/nadajv2.jpg"));
        ImageIcon dalej = new ImageIcon(getClass().getResource("/resources/dalej.jpg"));
        ImageIcon a = new ImageIcon(getClass().getResource("/resources/a.jpg"));
        ImageIcon b = new ImageIcon(getClass().getResource("/resources/b.jpg"));
        ImageIcon c = new ImageIcon(getClass().getResource("/resources/c.jpg"));
        ImageIcon d = new ImageIcon(getClass().getResource("/resources/menuklikniete.jpg"));

        JLabel dalejButton = new JLabel(dalej);
        JLabel aButton = new JLabel(a);
        JLabel bButton = new JLabel(b);
        JLabel cButton = new JLabel(c);
        JLabel menuKlikniete = new JLabel(d);


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
        JButton przyciskGab = createButton(240, 169, 100, 77, "");
        background.add(przyciskGab);
        background.add(aButton);
        placeBlady(240, 167, 100, 85, aButton);
        JButton przyciskGab2 = createButton(350, 169, 100, 77, "");
        background.add(przyciskGab2);
        background.add(bButton);
        placeBlady(350, 167, 100, 85, bButton);
        JButton przyciskGab3 = createButton(460, 169, 100, 77, "");
        background.add(przyciskGab3);
        background.add(cButton);
        placeBlady(460, 167, 100, 85, cButton);

        JButton przyciskDalej = createButton(234, 591, 333, 53, "");
        background.add(przyciskDalej);


           przyciskDalej.addActionListener(e -> {

               if(przyciskPoz.getText().equals("Imię i Nazwisko")
                       || przyciskPoz2.getText().equals("Miejscowość")
                       || przyciskPoz3.getText().equals("Ulica, numer budynku/mieszkania")
                       || przyciskPoz4.getText().equals("Numer telefonu"))
               {
                   JOptionPane.showMessageDialog(
                           null,
                           "Uzupełnij wszystkie pola"
                   );
                   return;
               }
               if(przyciskPoz4.getText().length() != 9)
               {
                   JOptionPane.showMessageDialog(
                           null,
                           "Numer telefonu musi mieć 9 cyfr"
                   );
                   return;
               }

               if(selectedSize.equals(""))
               {
                   JOptionPane.showMessageDialog(
                           null,
                           "Wybierz gabaryt przesyłki"
                   );
                   return;
               }

               if(profile.przyciskPoz.getText().equals("Jan")
                       || profile.przyciskPoz2.getText().equals("Kowalski")
                       || profile.przyciskPoz3.getText().equals("ul. Bęczkowska 12, Kielce")
                       || profile.przyciskPoz4.getText().equals("Numer telefonu"))
               {
                   JOptionPane.showMessageDialog(
                           null,
                           "Uzupełnij dane użytkownika"
                   );
                   return;
               }

               String kodPaczki =
                       "PP" + (int)(Math.random() * 1000000);
               PackageData pack =
                       new PackageData(                 loginUser,
                               przyciskPoz.getText(),
                               przyciskPoz2.getText(),
                               przyciskPoz3.getText(),
                               profile.przyciskPoz4.getText(),
                               przyciskPoz4.getText(),
                               selectedSize,
                               kodPaczki,
                               "Paczka czeka na nadanie"
                       );
               packageService.addPackage(pack);

               JOptionPane.showMessageDialog(
                       null,
                       "Płatność się powiodła.\n\nZapisz kod: " + kodPaczki +
                               "\nna paczce i zostaw paczkę w jednym z naszych punktów.",
                       "Płatność",
                       JOptionPane.INFORMATION_MESSAGE
               );
               setDefaultText();
               if(selectedLabel != null)
               {
                   selectedLabel.setVisible(false);
               }

               selectedLabel = null;
               selectedSize = "";
            });




        przyciskDalej.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("tutaj kiedyś będzie płatność");
            }
        });
        placeBlady(227, 588, 350, 65, dalejButton);
        background.add(dalejButton);





        JButton menuKliknieteButton = createButton(321, 676, 162, 39, "");
        background.add(menuKliknieteButton);
        placeBlady(295, 660, 218, 73, menuKlikniete);
        menuKliknieteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                setVisible(false);
                menu.setVisible(true);
            }
        });
        background.add(menuKlikniete);





        background.add(przyciskPoz);
        background.add(przyciskPoz2);
        background.add(przyciskPoz3);
        background.add(przyciskPoz4);

        textListener(przyciskPoz, "Imię i Nazwisko");
        textListener(przyciskPoz2, "Miejscowość");
        textListener(przyciskPoz3, "Ulica, numer budynku/mieszkania");
        textListener(przyciskPoz4, "Numer telefonu");

        mouseListenerIMG(przyciskDalej, dalejButton);
        mouseListenerIMG(menuKliknieteButton, menuKlikniete);
       // mouseListenerIMG(przyciskGab, aButton);
       // mouseListenerIMG(przyciskGab2, bButton);
        //mouseListenerIMG(przyciskGab3, cButton);

        clickListener(przyciskGab, aButton,"A");
        clickListener(przyciskGab2, bButton,"B");
        clickListener(przyciskGab3, cButton,"C");

        util.maxTextLenght(przyciskPoz,30);
        util.maxTextLenght(przyciskPoz2,20);
        util.maxTextLenght(przyciskPoz3,70);
        util.maxTextLenghtPhone(przyciskPoz4,9);

    }}