package service;

import GUI.LoginWindow;
import GUI.MenuWindow;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    ArrayList<User> users = new ArrayList<>();
    User user = new User("", "", 1);

    int nextID = 1;

    Scanner sc = new Scanner(System.in);
    MenuWindow menu = new MenuWindow();


    boolean zalogowano = false;


   public void register(String loginn, String hasloo) {
        String login = loginn;
        String haslo = hasloo;
        int countdown = 4;
        do {

        }
        while (loginExist(login));
        User user = new User(login, haslo, nextID++);
        users.add(user);
        System.out.println("Zarejestrowano użytkownika z ID: " + user.id);

    }

    boolean loginExist(String login) {


        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).login.equals(login)) {
                System.out.println("podany login jest zajety");
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


        do {
            countdown--;
            if (countdown == 0) {
                System.out.println("dane zostaly wprowadzone zle po raz 3, sprobuj ponownie pozniej");
                break;
            }
            if (goodPassword == true)
            {
                break;
            }

            //login = sc.next();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).login.equals(login)) {
                    goodLogin = true;
                    do {
                        whichACC=i;
                        countdownLogin--;
                        if (countdownLogin == 0) {
                            System.out.println("haslo zostalo wprowadzone zle po raz 3, sprobuj ponownie pozniej");
                            break;
                        }
                        System.out.println("dobry login, teraz podaj haslo");

                        //user.sprawdzHaslo(login, haslo);
                        if(user.sprawdzHaslo(users.get(i).haslo, haslo)==true)
                        {
                            System.out.println("hasło poprawne");
                            goodPassword=true;

                        }
                        else
                        {
                            System.out.println("zle haslo mordeczko");
                        }
                    } while(goodPassword==false);


                }
                else
                {
                    System.out.println("nie ma takiego loginu w bazie");
                }
            }


        }while (goodLogin) ;
        System.out.println("pomyślnie zalogowano dla konta "+ users.get(whichACC).login);
        zalogowano=true;
        return zalogowano;


    }
}
