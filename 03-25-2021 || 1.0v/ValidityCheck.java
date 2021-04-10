import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class ValidityCheck {
    public static void main(String[] args) {
        System.out.println("- - - Activation Key Validity Checker - - -");
        System.out.print(" >>Enter Activation Key: ");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        String rawKey = key.replace("-","");

        StringBuilder decodedKey = Decode(rawKey);
        System.out.println(decodedKey);
        String tempKey1 = new String(), tempKey2 = new String();

        for(int i=7;i>=0;i--){
            if(i%2==1){
                tempKey2+=decodedKey.charAt(i);
            } else {
                tempKey1+=decodedKey.charAt(i);
            }
        }

        if(checkValidityOf(tempKey1,tempKey2)){
            System.out.println("Entered key is VALID!");
        } else {
            System.out.println("Entered key is INVALID!");
        }
    }

    private static boolean checkValidityOf(String key1, String key2) {
        boolean valid;
        if(Integer.valueOf(key1)%24==0 && Integer.valueOf(key2)%16==0) {
            valid=true;
        } else { valid=false; }

        return valid;
    }

    private static StringBuilder Decode(String key) {
        StringBuilder newKey = new StringBuilder();
        for(int i=0;i<8;i++){
            if(i%2==1) {
                newKey.append(equalCharacterOf(key.charAt(i)));
            } else {
                newKey.append(key.charAt(i));
            }
        }
        return newKey;
    }

    private static int equalCharacterOf(char ch) {
        int newChar = 74-toUpperCase(ch);
        return newChar;
    }
}
