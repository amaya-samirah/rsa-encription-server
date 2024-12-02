package run;
import java.util.ArrayList;
// this will turn the int values into letters
public class Message extends Manager {

    public static ArrayList<String> cipherText = new ArrayList<String>();

    public static void createCipher() {
        intToString();
        printMessage();
    }

    public static void printMessage() {
        str("Your encoded message in ints is :");
        for (int i = 0; i < intMessage.size(); i++) {
            System.err.print(""+intMessage.get(i));
        }
        str("");

        str("Your encoded message in letters is: ");
        for (int i = 0; i < cipherText.size(); i++) {
            System.out.print(cipherText.get(i));
        }
        str("");
    }
    
    public static void intToString() {
        for (int i = 0; i < intMessage.size(); i++) {
            String let = numToLet(intMessage.get(i));
            cipherText.add(let);
        }
    }

    public static int mod(int num) {
        int mod;
        mod = num % 26;
        return mod;
    }

    public static String numToLet(int num) {
        String let = "";
        int temp = mod(num);
        for (int i = 0; i < alphabet.size(); i++) {
            if (temp == i) {
                let = alphabet.get(i);
            }
        }
        return let;
    }

    public static void testValues() {
        str("p: "+p);
        str("q: "+q);
        str("N: "+N);
        str("phiN: "+phiN);
        str("e: "+e);

        str("Your original message was");
        for (int i = 0; i < plainText.size(); i++) {
            System.out.print(""+plainText.get(i));
        }
         str("");
    }

    public static void reset() {
        plainText = new ArrayList<Double>();
        doubMessage = new ArrayList<Double>();
        intMessage = new ArrayList<Integer>();
        cipherText = new ArrayList<String>();
    }
}
