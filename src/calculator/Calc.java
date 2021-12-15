package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Calc {
    JFrame frame;
    JTextField textField;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btnC, btnB, btnM, btnD, btnE, btnP, btnS;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;
    double value = 0;
    char opt = ' ';
    boolean go = true;
    boolean addWrite = true;

    public Calc() {
        int[] x = {MARGIN_X, MARGIN_X + 90, 200, 290};
        int[] y = {MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y + 340, MARGIN_Y + 420};

        frame = new JFrame("Calc");
        textField = new JTextField("0");
        textField.setVisible(true);
        textField.setBackground(Color.blue);
        textField.setBounds(x[0], y[0], 350, 70);
        textField.setFont(new Font("",Font.PLAIN, 33));
        textField.setEditable(false);

        btnC = initButton("C", x[0], y[5], event -> {
            textField.setText("0");
            value = 0;
            opt = ' ';
        });

        btnB = initButton("<-", x[1], y[1], event -> {
            String str = textField.getText();
            StringBuilder str1 = new StringBuilder();
            for (int i = 0; i < str.length() - 1; i++) {
                str1.append(str.charAt(i));
            }
            if (str1.toString().equals("")) {
                textField.setText("0");
            } else {
                textField.setText(str1.toString());
            }
        });

        btnD = initButton("/", x[2], y[1], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '/';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '/';
                }
        });

        btnM = initButton("*", x[3], y[1], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '*';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '*';
                }
        });

        btn7 = initButton("7", x[0], y[2], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("7");
                } else {
                    textField.setText(textField.getText() + "7");
                }
            } else {
                addWrite = true;
                textField.setText("7");
            }
            go = true;
        });

        btn8 = initButton("8", x[1], y[2], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("8");
                } else {
                    textField.setText(textField.getText() + "8");
                }
            } else {
                addWrite = true;
                textField.setText("8");
            }
            go = true;
        });

        btn9 = initButton("9", x[2], y[2], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("9");
                } else {
                    textField.setText(textField.getText() + "9");
                }
            } else {
                addWrite = true;
                textField.setText("9");
            }
            go = true;
        });

        btnE = initButton("=", x[3], y[2], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '=';
                    addWrite = false;
                }
        });

        btn6 = initButton("6", x[0], y[3], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("6");
                } else {
                    textField.setText(textField.getText() + "6");
                }
            } else {
                addWrite = true;
                textField.setText("6");
            }
            go = true;
        });

        btn5 = initButton("5", x[1], y[3], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("5");
                } else {
                    textField.setText(textField.getText() + "5");
                }
            } else {
                addWrite = true;
                textField.setText("5");
            }
            go = true;
        });

        btn4 = initButton("4", x[2], y[3], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("4");
                } else {
                    textField.setText(textField.getText() + "4");
                }
            } else {
                addWrite = true;
                textField.setText("4");
            }
            go = true;
        });

        btnP = initButton("+", x[3], y[3], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '+';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '+';
                }
        });

        btn3 = initButton("3", x[0], y[4], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("3");
                } else {
                    textField.setText(textField.getText() + "3");
                }
            } else {
                addWrite = true;
                textField.setText("3");
            }
            go = true;
        });

        btn2 = initButton("2", x[1], y[4], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("2");
                } else {
                    textField.setText(textField.getText() + "2");
                }
            } else {
                addWrite = true;
                textField.setText("2");
            }
            go = true;
        });

        btn1 = initButton("1", x[2], y[4], event -> {
            if (addWrite){
                if (Pattern.matches("[0]*",textField.getText())) {
                    textField.setText("1");
                } else {
                    textField.setText(textField.getText() + "1");
                }
            } else {
                addWrite = true;
                textField.setText("1");
            }
            go = true;
        });

        btnS = initButton("-", x[3], y[4], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '-';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '-';
                }
        });

        btn0 = initButton("0", x[0], y[5], event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)",textField.getText()))
                if (go) {
                    value = calc(value, textField.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*",String.valueOf(value))) {
                        textField.setText(String.valueOf(value));
                    } else {
                        textField.setText(String.valueOf(value));
                    }
                    opt = '0';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '0';
                }
        });
        btn0.setVisible(false);
        frame.setSize(410,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(textField);
    }

    public JButton initButton(String label, int x, int y, ActionListener event) {
        JButton btn = new JButton(label);
        btn.addActionListener(event);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBounds(x, y, 75,80);
        btn.setFocusable(false);
        btn.setFont(new Font("",Font.PLAIN, 28));
        frame.add(btn);
        return btn;
    }

    public double calc(double x, String input, char opt) {
        double y = Double.parseDouble(input);
        switch (opt) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                return y;
        }
    }

    private Consumer<ItemEvent> calcType = event -> {
        if (event.getStateChange() != ItemEvent.SELECTED) return;

        String select = (String) event.getItem();
        switch (select) {
            case "Standard":
                frame.setSize(410,600);
                break;
        }
    };
    public static void main(String[] args) {
        new Calc();
    }
}
