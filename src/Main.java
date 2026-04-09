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
 static void  menu() {
     String option="";
     System.out.println("register ---> 1");
     System.out.println("login ---> 2");
     System.out.println("wyjdz ---> 3");
     System.out.println("Witam w menu logowania, wybierz jedną z powyzszych opcji: " );


     while(!option.equals("3")){
         option = sc.nextLine();
         switch (option) {
             case "1": uS.register(); menu(); break;
             case "2": uS.logging();  break;
             case "3": break;
         }}

 }



    public static void main(String[] args) {

//menu();
LoginWindow okno = new LoginWindow();
//okno.setVisible(true);
MenuWindow menu = new MenuWindow();
menu.setVisible(true);
//FollowPackWindow follow = new FollowPackWindow();
//follow.setVisible(true);

    }}

