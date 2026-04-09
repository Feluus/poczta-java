package model;

public class User {
   public String login;
   public String haslo;
   public int id=1;

    boolean zalogowano=false;

   public User(String login, String haslo,int id)
    {
 this.login=login;
 this.haslo=haslo;
 this.id=id;

    }


 public boolean sprawdzHaslo(String hasloBaza, String hasloUser)
{
    if(hasloBaza.equals(hasloUser))
    {
        zalogowano=true;

    }
    else
    {
        System.out.println("złe hasło");
        return false;

    }

    return zalogowano;

}

}
