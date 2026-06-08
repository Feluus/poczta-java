package model;

public class Employee {

    public String firstName;
    public String lastName;
    public String position;
    public String salary;

    public Employee(String firstName,
                    String lastName,
                    String position,
                    String salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
}