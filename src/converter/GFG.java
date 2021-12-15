package converter;

import javax.swing.*;
import java.awt.event.*;

public class GFG {
    public static void converter() {
        JFrame jf = new JFrame("CONVECTER");

        JLabel jl1 = new JLabel("Ruble:");
        jl1.setBounds(20, 40, 50, 30);
        JLabel jl2 = new JLabel("Dollars:");
        jl2.setBounds(170, 40, 50, 30);

        JTextField jt1 = new JTextField();
        jt1.setBounds(80, 40, 50, 30);
        JTextField jt2 = new JTextField();
        jt2.setBounds(240, 40, 50, 30);

        JButton jb1 = new JButton("Ruble");
        jb1.setBounds(50, 80,100, 15);
        JButton jb2 = new JButton("Dollar");
        jb2.setBounds(190,80,100,15);
        JButton jb3 = new JButton("close");
        jb3.setBounds(150,150,100,30);

//        ruble v dollar
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double d = Double.parseDouble(jt1.getText());
                double d1 = (d / 73.1);
                String str1 = String.format("%.1f", d1);
                jt2.setText(str1);
            }
        });

//        dollar to ruble
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double d2 = Double.parseDouble(jt2.getText());
                double d3 = (d2 * 73.1);
                String str2 = String.format("%.1f", d3);
                jt1.setText(str2);
            }
        });

//        close form
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jf.add(jl1);
        jf.add(jl2);
        jf.add(jt1);
        jf.add(jt2);
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);

        jf.setLayout(null);
        jf.setSize(400,300);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        converter();
    }
}
