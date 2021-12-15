package converter;

import java.math.BigInteger;

public class Biginteger {
    public static void main(String[] args){
        BigInteger b1 = new BigInteger("10");
        BigInteger b2 = new BigInteger("2");

        int compare = b1.compareTo(b2);

        if (compare == 0) {
            System.out.println("Equal");
        }

        if (compare == 1) {
            System.out.println("b1 is bigger");
        }

        if (compare == -1) {
            System.out.println("b1 is lesser");
        }

        BigInteger b = new BigInteger("15");
        System.out.println(b = b1.mod(b2));
    }

}
