import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame implements ActionListener {

    TextField tf;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnMin, btnMul, btnDiv, btnCls, btnEql;
    double num1 = 0, num2 = 0, res = 0;
    char op = '\0';
    String exp = "";

    public calculator() {
        setLayout(null);
        setTitle("Calculator Using AWT");
        setSize(500, 500);
        setVisible(true);

        // Buttons
        tf = new TextField();
        btn0 = new Button("0");
        btn1 = new Button("1");
        btn2 = new Button("2");
        btn3 = new Button("3");
        btn4 = new Button("4");
        btn5 = new Button("5");
        btn6 = new Button("6");
        btn7 = new Button("7");
        btn8 = new Button("8");
        btn9 = new Button("9");

        btnAdd = new Button(" + ");
        btnMin = new Button(" - ");
        btnMul = new Button(" *");
        btnDiv = new Button(" / ");
        btnCls = new Button(" C ");
        btnEql = new Button(" = ");

        // Button bounds
        tf.setBounds(20, 50, 210, 40);

        btn7.setBounds(20, 100, 50, 40);
        btn8.setBounds(75, 100, 50, 40);
        btn9.setBounds(130, 100, 50, 40);
        btnDiv.setBounds(185, 100, 50, 40);

        btn4.setBounds(20, 150, 50, 40);
        btn5.setBounds(75, 150, 50, 40);
        btn6.setBounds(130, 150, 50, 40);
        btnMul.setBounds(185, 150, 50, 40);

        btn1.setBounds(20, 200, 50, 40);
        btn2.setBounds(75, 200, 50, 40);
        btn3.setBounds(130, 200, 50, 40);
        btnMin.setBounds(185, 200, 50, 40);

        btn0.setBounds(20, 250, 50, 40);
        btnCls.setBounds(75, 250, 50, 40);
        btnEql.setBounds(130, 250, 50, 40);
        btnAdd.setBounds(185, 250, 50, 40);

        // Adding the components in frame
        add(tf);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btnDiv);

        add(btn4);
        add(btn5);
        add(btn6);
        add(btnMul);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btnMin);

        add(btn0);
        add(btnCls);
        add(btnEql);
        add(btnAdd);

        // Adding ActionListener
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnDiv.addActionListener(this);

        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btnMul.addActionListener(this);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btnMin.addActionListener(this);

        btn0.addActionListener(this);
        btnCls.addActionListener(this);
        btnEql.addActionListener(this);
        btnAdd.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn0) {
            tf.setText(tf.getText() + "0");
        } else if (ae.getSource() == btn1) {
            tf.setText(tf.getText() + "1");
        } else if (ae.getSource() == btn2) {
            tf.setText(tf.getText() + "2");
        } else if (ae.getSource() == btn3) {
            tf.setText(tf.getText() + "3");
        } else if (ae.getSource() == btn4) {
            tf.setText(tf.getText() + "4");
        } else if (ae.getSource() == btn5) {
            tf.setText(tf.getText() + "5");
        } else if (ae.getSource() == btn6) {
            tf.setText(tf.getText() + "6");
        } else if (ae.getSource() == btn7) {
            tf.setText(tf.getText() + "7");
        } else if (ae.getSource() == btn8) {
            tf.setText(tf.getText() + "8");
        } else if (ae.getSource() == btn9) {
            tf.setText(tf.getText() + "9");
        } else if (ae.getSource() == btnCls) {
            tf.setText("0");
        }

        else if (ae.getSource() == btnAdd || ae.getSource() == btnMin || ae.getSource() == btnMul || ae.getSource() == btnDiv) {
            exp = tf.getText() + ((Button) ae.getSource()).getLabel().charAt(1);  
            tf.setText(exp); // To print the num1 with operator
        }
    else if(ae.getSource() == btnEql) {
    try {
        String exp = tf.getText();  // To get the whole expression 
        String[] parts = exp.split("[+\\-*/]"); // To split the expression
        if (parts.length != 2) {
            tf.setText("Error");
            return;
        }
        
        int num1 = Integer.parseInt(parts[0]); // Get the num1
        int num2 = Integer.parseInt(parts[1]); // Get the num2
        char op = exp.replaceAll("[0-9]", "").charAt(0); // to get the operator 
        int res = 0;

        switch (op) {
            case '+': res = num1 + num2; break;
            case '-': res = num1 - num2; break;
            case '*': res = num1 * num2; break;
            case '/': res = num1 / num2; break;  
        }
        tf.setText(String.valueOf(res));
    } 
    catch (ArithmeticException e) {
        tf.setText("Error: Div by zero");
    } 
    catch (NumberFormatException e) {
        tf.setText("Error: Invalid input");
    }
}   

    }

    public static void main(String CP[]) {
        new calculator();
    }
}