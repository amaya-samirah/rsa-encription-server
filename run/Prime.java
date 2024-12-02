package run;

import java.util.ArrayList;  // adds ArrayList type to be used
import java.util.Random;  // adds 'Random' java library

public class Prime {
    public static double p;  // prime p
    public static double q;  // prime q
    public static double N;  // N = p * q
    public static double e;  // gcd(e, (p-1)(q-1)) = 1
    public static double phiN;  // Euler's Totient

    // makes p, q, N, phiN, e
    public static void generateValues() {
        Random rand = new Random();  // allows for random functions to be used

        boolean primeP = false;  // originially not prime
        // generate p
        while(!primeP) {
            p = rand.nextDouble(2, 10);
            if (isPrime(p)) {  // if value is prime then loop ends
                primeP = true;
            }
        }
        // generate q
        boolean primeQ = false;  // originially not prime
        while(!primeQ) {
            q = rand.nextDouble(10, 20);
            if (isPrime(q)) {  // if value is prime then loop ends
                primeQ = true;
            }
        }

        N = p * q;  // sets N
        phiN = (p-1) * (q-1);  // sets phiN
        generateE();  // sets e
    }

    // makes the e value
    public static void generateE() {
        // e = {e=Z+ | gcd(e, phiN) = 1}
        Random rand = new Random();
        boolean equals1 = false;  // originally sets gcd not equal to 1
        while(!equals1) {
            e = rand.nextDouble(phiN);
            if (isGCD(e)) {  // if gcd = 1
                equals1 = true;
            }
        }
    }
    
    // finds gcd of number
    public static boolean isGCD(double num) {
        boolean gcd = true;  // originally gcd set to 1
        double temp;  // if this value changed then gcd remains false

        // get factors of phiN
        ArrayList<Double> factors = new ArrayList<Double>();
        for (double i = 1; i < phiN; i++) {
            if ( phiN % i == 0) {
                factors.add(i);
            }
        }

        // compare factors with e
        // starting at 1 instead of 0 because know 1 is a factor
        // ending before phiN because know phiN is a factor
        for (int i = 1; i < factors.size()-1; i++) {  
            if (phiN % num == 0) {  // if e | phiN
                gcd = false;
            }
        }
        return gcd;
    }

    // determines if number is prime
    public static boolean isPrime(double num) {
        boolean prime = true;  // originally set prime

        if (num % 2 == 0) {  // if even
            prime = false;
        }
        else {  // if facots other than itself and 1
            for (int i = 2; i < num-1; i++) {
                if (num % i == 0 )  // if i | num
                prime = false;
            }
        }

        return prime;
    }

    // prints strings to console
    public static void str(String str) {
        System.out.println(str);
    }
}
