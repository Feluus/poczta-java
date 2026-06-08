package GUI;

import Utils.Utils;
import model.Employee;
import service.EmployeeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminWindow extends JFrame {
    Utils util = new Utils();



    private EmployeeService employeeService =
            new EmployeeService();

    private JTable employeeTable;
    private DefaultTableModel tableModel;

    public AdminWindow() {

        setTitle("Panel Admina");
        setSize(800, 820);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);

        ImageIcon tlo = new ImageIcon(
                getClass().getResource("/resources/adminTlo.jpg")
        );

        Image img = tlo.getImage().getScaledInstance(
                800,
                820,
                Image.SCALE_SMOOTH
        );

        JLabel background =
                new JLabel(new ImageIcon(img));

        background.setBounds(0, 0, 800, 820);
        background.setLayout(null);

        add(background);

        // =========================
        // TABELA PRACOWNIKÓW
        // =========================

        tableModel = new DefaultTableModel(
                new String[]{
                        "Imię",
                        "Nazwisko",
                        "Stanowisko",
                        "Pensja"
                },
                0
        );

        employeeTable = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scroll =
                new JScrollPane(employeeTable);

        scroll.setBounds(70, 120, 660, 250);

        background.add(scroll);

        // =========================
        // POLA DODAWANIA
        // =========================

        JTextField imieField =
                new JTextField();

        JTextField nazwiskoField =
                new JTextField();

        JTextField pensjaField =
                new JTextField();

        String[] stanowiska = {
                "Listonosz",
                "Kurier",
                "Pracownik okienka",
                "Kierownik",
                "Magazynier"
        };

        JComboBox<String> stanowiskoBox =
                new JComboBox<>(stanowiska);

        imieField.setBounds(70, 420, 120, 25);
        nazwiskoField.setBounds(210, 420, 120, 25);
        stanowiskoBox.setBounds(350, 420, 150, 25);
        pensjaField.setBounds(520, 420, 100, 25);

        background.add(imieField);
        background.add(nazwiskoField);
        background.add(stanowiskoBox);
        background.add(pensjaField);

        // =========================
        // DODAJ
        // =========================

        JButton dodajPrzycisk =
                new JButton("Dodaj");

        dodajPrzycisk.setBounds(
                640,
                420,
                100,
                25
        );

        background.add(dodajPrzycisk);

        dodajPrzycisk.addActionListener(e -> {

            if(imieField.getText().isEmpty()
                    || nazwiskoField.getText().isEmpty()
                    || pensjaField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Uzupełnij wszystkie pola"
                );
                return;
            }

            Employee employee =
                    new Employee(
                            imieField.getText(),
                            nazwiskoField.getText(),
                            (String) stanowiskoBox.getSelectedItem(),
                            pensjaField.getText()
                    );

            employeeService.addEmployee(employee);

            refreshEmployees();

            imieField.setText("");
            nazwiskoField.setText("");
            pensjaField.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Dodano pracownika"
            );
        });

        // =========================
        // USUŃ
        // =========================

        JButton usunPrzycisk =
                new JButton("Usuń");

        usunPrzycisk.setBounds(
                640,
                460,
                100,
                25
        );

        background.add(usunPrzycisk);

        usunPrzycisk.addActionListener(e -> {

            int row = employeeTable.getSelectedRow();

            if(row == -1)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Zaznacz pracownika"
                );
                return;
            }

            String imie =
                    tableModel.getValueAt(row,0).toString();

            String nazwisko =
                    tableModel.getValueAt(row,1).toString();

            employeeService.removeEmployee(
                    imie,
                    nazwisko
            );

            refreshEmployees();

            JOptionPane.showMessageDialog(
                    null,
                    "Usunięto pracownika"
            );
        });

        // =========================
        // EDYTUJ
        // =========================

        JButton edytujPrzycisk =
                new JButton("Edytuj");

        edytujPrzycisk.setBounds(
                640,
                500,
                100,
                25
        );

        background.add(edytujPrzycisk);

        edytujPrzycisk.addActionListener(e -> {

            int row = employeeTable.getSelectedRow();

            if(row == -1)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Zaznacz pracownika"
                );
                return;
            }

            String imie =
                    tableModel.getValueAt(row,0).toString();

            String nazwisko =
                    tableModel.getValueAt(row,1).toString();

            String noweStanowisko =
                    JOptionPane.showInputDialog(
                            "Nowe stanowisko",
                            tableModel.getValueAt(row,2)
                    );

            if(noweStanowisko == null)
                return;

            String nowaPensja =
                    JOptionPane.showInputDialog(
                            "Nowa pensja",
                            tableModel.getValueAt(row,3)
                    );

            if(nowaPensja == null)
                return;

            employeeService.editEmployee(
                    imie,
                    nazwisko,
                    noweStanowisko,
                    nowaPensja
            );

            refreshEmployees();

            JOptionPane.showMessageDialog(
                    null,
                    "Zaktualizowano dane"
            );
        });




        refreshEmployees();
        util.maxTextLenght(imieField, 30);
        util.maxTextLenght(nazwiskoField, 30);
        util.maxTextLenghtPhone(pensjaField, 6);
    }

    private void refreshEmployees()
    {
        tableModel.setRowCount(0);

        for(Employee e : employeeService.getEmployees())
        {
            tableModel.addRow(
                    new Object[]{
                            e.firstName,
                            e.lastName,
                            e.position,
                            e.salary
                    }
            );
        }

    }

}