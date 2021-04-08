import java.util.Scanner;

import static java.lang.Character.*;

public class ValidityCheck {
    public static void main(String[] args) {
        System.out.println("- - - Activation Key Validity Checker - - -");
        System.out.print(" >>Enter Activation Key: ");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();

        if(checkKey(key)){
            String rawKey = key.replace("-","");

            StringBuilder decodedKey = Decode(rawKey);
            String tempKey1 = "", tempKey2 = "";

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
        } else {
            System.out.println("Entered key format INCORRECT!");
        }
    }

    private static boolean checkKey(String key) {
        int cntr1=0,cntr2=0;
        if(key.length()==9){
            for(int i=0;i<9;i++){
                if(key.charAt(i)=='-' && i==4){
                    cntr1+=1;
                }
            }

            if(cntr1==1){
                String rawKey = key.replace("-","");
                for(int i=0;i<8;i++){
                    if(isDigit(rawKey.charAt(i)) && i%2==0){
                        cntr2+=1;
                    } else if(isAlphabetic(rawKey.charAt(i)) && isUpperCase(rawKey.charAt(i)) && i%2==1){
                        cntr2+=1;
                    }
                }
                if(cntr2==8){ return true; }
            }
        }
        return false;
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
