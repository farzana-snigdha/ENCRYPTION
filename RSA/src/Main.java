import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Encryption a = new Encryption();
        Scanner input = new Scanner(System.in);

        System.out.print("enter p : ");

        //to get 2 large prime numbers
        String p = input.next();
        BigInteger a1 = new BigInteger(p);

        if (a1.isProbablePrime(1)) {

        } else {
            System.out.println("not prime");
            System.exit(0);
        }
        System.out.print("enter q : ");
        String q = input.next();
        BigInteger a2 = new BigInteger(q);

        if (a2.isProbablePrime(1)) {

        } else {
            System.out.println("not prime");
            System.exit(0);
        }


        BigInteger N = a1.multiply(a2);

        BigInteger phi_n = (a1.subtract(BigInteger.ONE)).multiply(a2.subtract(BigInteger.ONE));
        // get e
        BigInteger e;
        for (e = BigInteger.valueOf(2); e.compareTo(phi_n) < 0; e = e.add(BigInteger.ONE)) {
            int compareValue = a.gcd(e, phi_n).compareTo(BigInteger.ONE);
            if (compareValue == 0) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        System.out.println("the value of N = " + N);

        //get d
        BigInteger d = e.modInverse(phi_n);
        // System.out.println("the value of d = " + d);

        System.out.println("Do you want to encrypt or decrypt(e/d)? ");
        String ans = input.next();

        if (ans.equals("e")) {
            //encrypt msg
            System.out.println("Enter the message you want to encrypt:");

            BigInteger msg = input.nextBigInteger();
            BigInteger reverse = BigInteger.ZERO;
            //reverse the message
            while (msg.compareTo(BigInteger.ZERO)!=0) {
                reverse = (reverse.multiply(BigInteger.TEN)).add(msg.mod(BigInteger.TEN));
                msg = msg.divide(BigInteger.TEN);
            }
            System.out.println("Encrypted message is : ");
            while (reverse.compareTo(BigInteger.ZERO)!=0) {
                BigInteger c = reverse.pow(e.intValue());
                BigInteger s = c.mod(N);
              //  System.out.println((reverse .mod(BigInteger.TEN)));

                System.out.print(s);
                reverse=reverse.divide(BigInteger.TEN);
            }
        } else if (ans.equals("d")) {
            //decrypt msg
            System.out.println("enter encrypted message : ");
            BigInteger msg = input.nextBigInteger();
            BigInteger reverse = BigInteger.ZERO;
            //reverse the message
            while (msg.compareTo(BigInteger.ZERO)!=0) {
                reverse = (reverse.multiply(BigInteger.TEN)).add(msg.mod(BigInteger.TEN));
                msg = msg.divide(BigInteger.TEN);
            }
            System.out.println("Decrypted message is : ");
            while (reverse.compareTo(BigInteger.ZERO)!=0) {

                BigInteger m = reverse.pow(d.intValue());
                BigInteger s = m.mod(N);
                System.out.print(s);
                reverse=reverse.divide(BigInteger.TEN);
            }


        }
    }
}