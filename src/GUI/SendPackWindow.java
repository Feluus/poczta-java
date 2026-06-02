package GUI;

import Utils.Utils;

import javax.swing.*;
import java.awt.Image;

public class SendPackWindow extends JFrame {
   public static boolean isClicked =false;
    Utils util = new Utils();

    public static JTextField przyciskPoz = createTextField(278, 329, 234, 15, "Imię i Nazwisko");
    public static JTextField przyciskPoz2 = createTextField(278, 388, 234, 15, "Miejscowość");
    public static JTextField przyciskPoz3 = createTextField(278, 444, 234, 15, "Ulica, numer budynku/mieszkania");
    public static JTextField przyciskPoz4 = createTextField(278, 504, 234, 15, "Numer telefonu");


    public static void clickListener(JButton buttonTitle, JLabel buttonTitle2) {
        final int[] tempo = {1};

        buttonTitle.addActionListener(e -> {
     tempo[0]++;

     if(tempo[0] %2==0){
         isClicked=true;
         buttonTitle2.setVisible(true);
     }
     else{
         buttonTitle2.setVisible(false);
     }
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
    }



    public SendPackWindow(MenuWindow menu) {
        setTitle("nadanie paczki");
        setSize(800, 820);
        setLayout(null);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo = new ImageIcon("src/resources/nadajv2.jpg");
        ImageIcon dalej = new ImageIcon("src/resources/dalej.jpg");
        ImageIcon a = new ImageIcon("src/resources/a.jpg");
        ImageIcon b = new ImageIcon("src/resources/b.jpg");
        ImageIcon c = new ImageIcon("src/resources/c.jpg");
        ImageIcon d = new ImageIcon("src/resources/menuklikniete.jpg");

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

        clickListener(przyciskGab, aButton);
        clickListener(przyciskGab2, bButton);
        clickListener(przyciskGab3, cButton);

        util.maxTextLenght(przyciskPoz,30);
        util.maxTextLenght(przyciskPoz2,20);
        util.maxTextLenght(przyciskPoz3,70);
        util.maxTextLenghtPhone(przyciskPoz4,9);

    }}