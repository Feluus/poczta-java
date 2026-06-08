package service;

import GUI.AdminWindow;
import GUI.LoginWindow;
import GUI.MenuWindow;
import model.User;


import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class UserService {

    ArrayList<User> users = new ArrayList<>();
  //  User user = new User("admin", "admin", 1);

    int nextID = 2;


    Scanner sc = new Scanner(System.in);

public void saveUsersToFile()
{

    try (PrintWriter writer = new PrintWriter("src/TXT/users.txt")) {

        for(User user : users) {

            writer.println(
                    user.login + ";" +
                            user.haslo + ";" +
                            user.id
            );

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

}

public void loadUsersFromFile()
{
    users.clear();
    try (Scanner fileScanner = new Scanner(new File("src/TXT/users.txt"))) {

        while(fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] data = line.split(";");

            String login = data[0];
            String haslo = data[1];
            int id = Integer.parseInt(data[2]);

            users.add(
                    new User(login, haslo, id)
            );
            if(id >= nextID)
            {
                nextID = id + 1;
            }

        }

    } catch (Exception e) {

        e.printStackTrace();

    }
    System.out.println("Wczytano użytkowników: " + users.size());
}

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
           saveUsersToFile();
           System.out.println("Zarejestrowano użytkownika z ID: " + user.id);
           JOptionPane.showMessageDialog(null,"Zarejestrowano użytkownika o loginie: "+ user.login,"",JOptionPane.INFORMATION_MESSAGE );
       }
       else if(loginExist(login)){
           JOptionPane.showMessageDialog(null,"login już istnieje","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
       }


    }

    public boolean loginExist(String login) {


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

        boolean znaleziono = false;
        boolean zalogowano=false;




            for (int i = 0; i < users.size(); i++) {

                if (login.equals("admin")){
                    znaleziono = true;
                    if(haslo.equals("admin")){


                        AdminWindow admin = new AdminWindow();
                        admin.setVisible(true);
                        zalogowano=true;
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"wpisano złe hasło","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                        System.out.println("zle haslo admina");
                        return false;
                    }

                }

               if (users.get(i).login.equals(login)) {
                    znaleziono = true;

                        if(users.get(i).haslo.equals(haslo))
                        {
                            System.out.println("hasło poprawne");
                            zalogowano=true;

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"wpisano złe hasło","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
                            System.out.println("zle haslo");

                        }


                    break;


                }

            }

        if(!znaleziono)
        {
            JOptionPane.showMessageDialog(null,"nie ma takiego loginu w bazie","Błąd rejestracji",JOptionPane.ERROR_MESSAGE );
            zalogowano=false;
        }






       // System.out.println("pomyślnie zalogowano dla konta "+ users.get(whichACC).login);
        return zalogowano;



    }

   public UserService(){

    loadUsersFromFile();
   }



}
