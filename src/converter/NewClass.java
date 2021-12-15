package converter;

import javax.swing.text.html.ListView;
import java.util.*;

public class NewClass {
    public static void main(String[] args) {
        Currency c1 = Currency.getInstance("RUB");
        Currency c2 = Currency.getInstance("JPY");
        Currency c3 = Currency.getInstance("USD");

        String cCode1 = c1.getCurrencyCode();
        String cCode2 = c2.getCurrencyCode();
        System.out.println("Australian Dollar code : " + cCode1);
        System.out.println("Japan Yen code : " + cCode2);
        System.out.println();

        int D1 = c1.getDefaultFractionDigits();
        System.out.println("AUD Fraction digits : " + D1);

        int D2 = c2.getDefaultFractionDigits();
        System.out.println("JPY fraction digits : " + D2);

        System.out.println(c1.getDisplayName());
        System.out.println(c2.getSymbol());

        System.out.println("JPY Symbol : " + c1.getSymbol());
        System.out.println("JPY Symbol : " + c2.getSymbol());
        System.out.println("USD Symbol : " + c3.getSymbol());
        System.out.println();
    }
}
