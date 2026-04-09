package service;

import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    ArrayList<User> users = new ArrayList<>();
    User user = new User("", "", 1);
    int nextID = 1;

    Scanner sc = new Scanner(System.in);
    boolean zalogowano = false;


   public void register() {
        String login = "";
        String haslo = "";
        int countdown = 4;
        do {
            System.out.println("Podaj login");
            login = sc.next();
        }
        while (loginExist(login));
        System.out.println("Podaj haslo");
        haslo = sc.next();
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

    public void logging() {
        String login = "";
        String haslo = "";
        int countdown = 4;
        int countdownLogin=3;
        int whichACC=0;
        boolean goodLogin = false;
        boolean goodPassword=false;


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
            System.out.println("podaj login");
            login = sc.next();
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
                        haslo = sc.next();
                        //user.sprawdzHaslo(login, haslo);
                        if(user.sprawdzHaslo(users.get(i).haslo, haslo)==true)
                        {
                            System.out.println("hasło poprawne");
                            goodPassword=true;
                        }
                    } while(goodPassword==false);


                }
            }


        }while (goodLogin) ;
        System.out.println("pomyślnie zalogowano dla konta "+ users.get(whichACC).login);
    }
}
