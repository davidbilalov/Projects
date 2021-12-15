package converter;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DigitalWatch implements Runnable{
    int hours, minutes, seconds;
    Thread t = null;
    String string = "";
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    Font font = new Font("Serif", Font.ITALIC, 100);
    DigitalWatch () {
        t = new Thread(this);
        t.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,500,500);
        frame.setTitle("Digital Watch");
        frame.setLayout(null);
        frame.setVisible(true);

        label.setBounds(20,20,400,100);
        label.setBackground(Color.blue);
        label.setFont(font);

        frame.add(label);

    }

    public void run() {
        try {
            while(true) {
                Calendar cal = Calendar.getInstance();
                hours = cal.get( Calendar.HOUR_OF_DAY );
                if ( hours > 12 ) hours -= 12;
                minutes = cal.get( Calendar.MINUTE );
                seconds = cal.get( Calendar.SECOND );

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                string = formatter.format( date );

                printTime();

                Thread.sleep( 1000 );
            }
        }catch(Exception e) {}
    }

    public void printTime() {
        label.setText(string);
    }
    public static void main(String[] args) {
        new DigitalWatch();
    }
}