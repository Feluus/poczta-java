package test;

import model.Employee;
import org.junit.jupiter.api.Test;
import service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Test
    void shouldAddEmployee() {

        EmployeeService service =
                new EmployeeService();

        Employee employee =
                new Employee(
                        "Jan",
                        "Kowalski",
                        "Kurier",
                        "5000"
                );

        service.addEmployee(employee);

        boolean found = service.getEmployees()
                .stream()
                .anyMatch(e ->
                        e.firstName.equals("Jan")
                                &&
                                e.lastName.equals("Kowalski"));

        assertTrue(found);
    }

    @Test
    void shouldEditEmployee() {

        EmployeeService service =
                new EmployeeService();

        Employee employee =
                new Employee(
                        "Adam",
                        "Nowak",
                        "Listonosz",
                        "4000"
                );

        service.addEmployee(employee);

        service.editEmployee(
                "Adam",
                "Nowak",
                "Kierownik",
                "7000"
        );

        Employee found =
                service.getEmployees()
                        .stream()
                        .filter(e ->
                                e.firstName.equals("Adam")
                                        &&
                                        e.lastName.equals("Nowak"))
                        .findFirst()
                        .orElse(null);

        assertNotNull(found);
        assertEquals("Kierownik", found.position);
        assertEquals("7000", found.salary);
    }

    @Test
    void shouldRemoveEmployee() {

        EmployeeService service =
                new EmployeeService();

        Employee employee =
                new Employee(
                        "Filip",
                        "Testowy",
                        "Kurier",
                        "5000"
                );

        service.addEmployee(employee);

        service.removeEmployee(
                "Filip",
                "Testowy"
        );

        boolean found =
                service.getEmployees()
                        .stream()
                        .anyMatch(e ->
                                e.firstName.equals("Filip")
                                        &&
                                        e.lastName.equals("Testowy"));

        assertFalse(found);
    }
}