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
        for (; ; ) {
            if (a1.isProbablePrime(1)) {

            } else System.out.println("not prime");
            break;
        }
        System.out.print("enter q : ");
        String q = input.next();
        BigInteger a2 = new BigInteger(q);
        for (; ; ) {
            if (a2.isProbablePrime(1)) {

            } else System.out.println("not prime");
            break;
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

        BigInteger d = e.modInverse(phi_n);
        System.out.println("the value of d = " + d);

        System.out.println("Do you want to encrypt or decrypt(e/d)? ");
        String ans = input.next();
        if (ans.equals("e")) {
            //encrypt msg
            System.out.print("enter original message : ");
            BigInteger msg = input.nextBigInteger();
            BigInteger c = msg.pow(e.intValue());
            BigInteger s = c.mod(N);
            System.out.println("Encrypted message is : " + s);
        }

        else if (ans.equals("d")) {
            //decrypt msg
            System.out.println("enter encrypted message : ");
            BigInteger ms = input.nextBigInteger();
            BigInteger m = ms.pow(d.intValue());
            BigInteger mod = m.mod(N);
            System.out.println("Derypted message is : " + mod);


        }
    }
}