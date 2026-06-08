package model;

public class UserProfile {

    public String login;
    public String firstName;
    public String lastName;
    public String address;
    public String phone;

    public UserProfile(String login,
                       String firstName,
                       String lastName,
                       String address,
                       String phone) {

        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }
}