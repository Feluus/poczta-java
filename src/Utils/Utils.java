package Utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Utils extends JFrame {

    public void maxTextLenght(JTextField fieldName, int lenght) {


        fieldName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (fieldName.getText().length() >= lenght) {
                    e.consume();
                }
            }
        });


    }

    public void maxTextLenghtPhone(JTextField fieldName, int lenght) {


        fieldName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (fieldName.getText().length() >= lenght) {
                    e.consume();
                }
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });


    }









}
