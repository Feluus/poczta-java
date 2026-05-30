import GUI.LoginWindow;
import GUI.MenuWindow;
import GUI.FollowPackWindow;
import service.UserService;

import java.util.Scanner;
public class Main {
    //stałe
    static Scanner sc = new Scanner(System.in);
    static UserService uS= new UserService();
    //Funkcje




    public static void main(String[] args) {


LoginWindow okno = new LoginWindow();
okno.setVisible(true);
//menuWindow menu = new MenuWindow();
//menu.setVisible(true);
//FollowPackWindow follow = new FollowPackWindow();
//follow.setVisible(true);
        //uS.logging("jas","kapela");

    }}

