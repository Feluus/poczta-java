package service;

import model.Employee;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        loadEmployeesFromFile();
    }

    public void saveEmployeesToFile() {

        try(PrintWriter writer =
                    new PrintWriter("src/TXT/employees.txt"))
        {
            for(Employee e : employees)
            {
                writer.println(
                        e.firstName + ";" +
                                e.lastName + ";" +
                                e.position + ";" +
                                e.salary
                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void removeEmployee(
            String firstName,
            String lastName)
    {
        employees.removeIf(e ->
                e.firstName.equals(firstName)
                        &&
                        e.lastName.equals(lastName));

        saveEmployeesToFile();
    }
    public void loadEmployeesFromFile() {

        employees.clear();

        try(Scanner scanner =
                    new Scanner(new File("src/TXT/employees.txt")))
        {
            while(scanner.hasNextLine())
            {
                String[] data =
                        scanner.nextLine().split(";");

                employees.add(
                        new Employee(
                                data[0],
                                data[1],
                                data[2],
                                data[3]
                        )
                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
        saveEmployeesToFile();
    }

    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }
    public void editEmployee(
            String firstName,
            String lastName,
            String newPosition,
            String newSalary)
    {
        for(Employee e : employees)
        {
            if(e.firstName.equals(firstName)
                    &&
                    e.lastName.equals(lastName))
            {
                e.position = newPosition;
                e.salary = newSalary;

                saveEmployeesToFile();
                return;
            }
        }
    }
}