package run;

public class RSA extends Message {
    
    public static void main(String[] args) {
        str("Welcome to the RSA Encoding Program!");
        init();  // initialization
        boolean end = false;
        while(!end) {
            str("Would you like to encode a message, enter \"yes\" or \"no\"");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                run();
                createCipher();
                //testValues();
            }
            else if (choice.equalsIgnoreCase("no")) {
                end = true;
            }
            reset();  // resets previously input values
        }

        str("You have exited the program. \nGoodbye!");

        
    }
}
