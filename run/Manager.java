package run;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Manager extends Prime {

    public static ArrayList<Double> plainText = new ArrayList<Double>();  // user message
    public static ArrayList<Double> doubMessage = new ArrayList<Double>();  // encoded message as double values
    public static ArrayList<String> alphabet = new ArrayList<String>();  // English alphabet
    public static ArrayList<Integer> intMessage = new ArrayList<Integer>();  // encoded message as int values
    
    public static Scanner keyboard = new Scanner(System.in);

    public static void doubleToInt() {
        for (int i = 0; i < doubMessage.size(); i++) {
            double temp = doubMessage.get(i);
            intMessage.add((int) temp);
        }
    }

    // initialize all necessary values
    public static void init() {
        populateAlphabet();
        generateValues();  // creates values p, q, N, phiN, e
    }

    public static void run(String message) {
        //str("Enter a message to endode with no spaces:");
        //String input = keyboard.nextLine();
        
        
        // convert String input to double values
        addPlainText(message);
        encode(plainText);
        // str("Your encoded message is:");
        // for (int i = 0; i < doubMessage.size(); i++) {
        //     System.out.print(doubMessage.get(i)+" ");
        // }
        // str("");
    }

    // encodes numbers with RSA
    public static void encode(ArrayList<Double> text) {
        // cipherText[i] = m^e mod N
        double temp;
        double mod ;
        for (int i = 0; i < text.size(); i++) {
            temp = Math.pow(text.get(i), e);
            mod = temp % 26;
            doubMessage.add(mod);
        }
        doubleToInt();
    }

    // takes string input and puts into array of plainText
    public static void addPlainText(String input) {
        int length = input.length();
        char[] inputs = new char[length];
        for (int i = 0; i < length; i++) {
            inputs[i] = input.charAt(i);
            //str(""+inputs[i]);
        }

        for (int i = 0; i < length; i++) {
            String temp = String.valueOf(inputs[i]);  // char to string
            plainText.add(Double.parseDouble(temp));  // string to double
        }
    }

    public static void populateAlphabet() {
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");
    }
}
