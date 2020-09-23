import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String newstring = "";
        for (int i = 0; i< message.length(); i++){
            char strChar = message.charAt(i);
            if (65<= strChar && strChar<=90){
                strChar = (char)((strChar +3));
            }
            else if(97<= strChar && strChar<=90){
                strChar = (char)((strChar +3));
            }
            newstring = newstring + strChar;        
        }
        return newstring;
    }

    public static String decryptCaesar(String message) {
        String newstring = "";
        for (int i = 0; i< message.length(); i++){
            char strChar = message.charAt(i);
            if (65<= strChar && strChar<=90){
                strChar = (char)((strChar - 3));
            }
            else if(97<= strChar && strChar<=90){
                strChar = (char)((strChar - 3));
            }
            newstring = newstring + strChar;        
        }
        return newstring;
    }

    public static String encryptCaesarKey(String message, int key) {
        String newstring = "";
        key = key%26;
        for (int i = 0; 1 < message.length(); i++){
            char ch = message.charAt(i);
            if ((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)){
                if ((ch >= (90-(key-1)) && ch <= 90)||(ch >= 122-(key-1) && ch <= 122)){
                    newstring += (char)(ch-(26-key));
                }
                else {
                    newstring += (char)(ch+key);
                }
            }
            else {
                newstring += ch;
            }
        }  
    }
    
    public static String decryptCaesarKey(String message, int key) {
        String newstring = "";
        key = key%26;
        for (int i = 0; 1 < message.length(); i++){
            char ch = message.charAt(i);
            if ((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)){
                if ((ch >= 65 && ch <= 65 + (key-1))||(ch >= 97 && ch <= 97 + (key-1))){
                    newstring += (char)(ch-(26-key));
                }
                else {
                    newstring += (char)(ch+key);
                }
            }
            else {
                newstring += ch;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
