package service;

import GUI.LoginWindow;
import GUI.MenuWindow;
import model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    ArrayList<User> users = new ArrayList<>();
    User user = new User("admin", "admin", 1);
    int nextID = 2;
    Scanner sc = new Scanner(System.in);



   public void register(String loginn, String hasloo) {
        String login = loginn;
        String haslo = hasloo;


       if(login.equals("Wpisz login"))
        {
            JOptionPane.showMessageDialog(null,"Wprowadź login!","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
        }
       else if(!loginExist(login))
       {
           User user = new User(login, haslo, nextID++);
           users.add(user);
           System.out.println("Zarejestrowano użytkownika z ID: " + user.id);
           JOptionPane.showMessageDialog(null,"Zarejestrowano użytkownika o loginie: "+ user.login,"",JOptionPane.INFORMATION_MESSAGE );
       }
       else if(loginExist(login)){
           JOptionPane.showMessageDialog(null,"login już istnieje","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
       }


    }

    boolean loginExist(String login) {


        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).login.equals(login)) {

                return true;

            }

        }
        return false;
    }

    public boolean logging(String loginn, String hasloo) {
        String login = loginn;
        String haslo = hasloo;
        int countdown = 4;
        int countdownLogin=3;
        int whichACC=0;
        boolean goodLogin = false;
        boolean goodPassword=false;
        boolean zalogowano=false;


       /* do {
            countdown--;

            if (goodPassword == true)
            {
                break;
            }

            //login = sc.next();
            for (int i = 0; i < users.size(); i++) {

                if(users.get(i).equals(null)){
                    JOptionPane.showMessageDialog(null,"nie ma takiego użytkownikaaa","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );

                }
                else if (users.get(i).login.equals(login)) {
                    goodLogin = true;

                    do {
                        whichACC=i;
                        countdownLogin--;


                        if(user.sprawdzHaslo(users.get(i).haslo, haslo)==true)
                        {
                            System.out.println("hasło poprawne");
                            goodPassword=true;

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"wpisano złe hasło","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                            System.out.println("zle haslo mordeczko");

                        }
                    } while(goodPassword==false);




                }
                else
                {
                    JOptionPane.showMessageDialog(null,"nie ma takiego loginu w bazie","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                }
            }


        }while (goodLogin) ;

        */

            for (int i = 0; i < users.size(); i++) {

                if(users.get(i).login.equals(null)){
                    JOptionPane.showMessageDialog(null,"nie ma takiego użytkownikaaa","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );

                }
                else if (users.get(i).login.equals(login)) {
                    goodLogin = true;


                        whichACC=i;
                        countdownLogin--;


                        if(user.sprawdzHaslo(users.get(i).haslo, haslo)==true)
                        {
                            System.out.println("hasło poprawne");
                            goodPassword=true;
                            zalogowano=true;

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"wpisano złe hasło","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                            System.out.println("zle haslo");
                            zalogowano=false;

                        }





                }
                else
                {
                    JOptionPane.showMessageDialog(null,"nie ma takiego loginu w bazie","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                    zalogowano=false;
                }
            }





       // System.out.println("pomyślnie zalogowano dla konta "+ users.get(whichACC).login);
        return zalogowano;


    }
}
