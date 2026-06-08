package GUI;
import model.PackageData;
import service.PackageService;

import javax.swing.*;

public class PackHistory extends JFrame{

   public PackHistory(MenuWindow menu,String loginUser)
    {

        PackageService packageService = new PackageService();
        packageService.loadPackagesFromFile();


        setTitle("Historia Twoich paczek");
        setSize(800,820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo =new ImageIcon(getClass().getResource("/resources/packhistory.jpg"));
        ImageIcon d = new ImageIcon(getClass().getResource("/resources/menukliknietev3.jpg"));
        //ImageIcon e = new ImageIcon(getClass().getResource("/resources/reklamacjaklikniete.jpg"));

        JLabel background = new JLabel(tlo);
        JLabel menuKlikniete = new JLabel(d);
        //JLabel reklamacjaKlikniete = new JLabel(e);

        background.setBounds(-40,-40,872,878);
        background.setLayout(null);
        add(background);
        background.setVisible(true);


        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });


        JTextArea area = new JTextArea();

        area.setEditable(false);
        area.setOpaque(false);

        for(PackageData p : packageService.getPackages())
        {

            if(p.ownerLogin.equals(loginUser))
            {
                area.append(
                        "Kod: " + p.packageCode + "\n" +
                          "Odbiorca: " +p.receiverName + "\n" +
                        "Gabaryt: " + p.size + "\n\n"
                );
            }
        }

        JScrollPane scroll = new JScrollPane(area);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.setBounds(225, 235, 470, 470);

        background.add(scroll);



//        JButton reklamacjaKliknieteButton = SendPackWindow.createButton(333, 678, 220, 62, "");
//        background.add(reklamacjaKliknieteButton);
//        SendPackWindow.placeBlady(330, 671, 225, 70, reklamacjaKlikniete);
//        SendPackWindow.mouseListenerIMG(reklamacjaKliknieteButton, reklamacjaKlikniete);
//        reklamacjaKliknieteButton.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent e) {
//                System.out.println("tutaj kiedys bedzie formularz reklamacyjny");
//               // setVisible(false);
//                //menu.setVisible(true);
//            }
//        });
//        background.add(reklamacjaKlikniete);



        JButton menuKliknieteButton = SendPackWindow.createButton(360, 747, 168, 48, "");
        background.add(menuKliknieteButton);
        SendPackWindow.placeBlady(360, 747, 168, 48, menuKlikniete);
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
