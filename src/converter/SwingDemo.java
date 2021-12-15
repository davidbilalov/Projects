package converter;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String args[]) throws BadLocationException {
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        JTextPane textPane = new JTextPane();

//        textPane.setBackground(Color.blue);
        textPane.setBackground(Color.green);

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        textPane.setCharacterAttributes(attributeSet, true);
        textPane.setText("We waited long for ");
        Font font = new Font("Serif", Font.ITALIC, 18);
        textPane.setFont(font);
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("", null);
        StyleConstants.setForeground(style, Color.red);
        StyleConstants.setBackground(style, Color.white);
        doc.insertString(doc.getLength(), "Game of Thrones ", style);
        StyleConstants.setForeground(style, Color.yellow);
        StyleConstants.setBackground(style, Color.gray);
        doc.insertString(doc.getLength(), "Season 8", style);
        JScrollPane scrollPane = new JScrollPane(textPane);
        container.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}