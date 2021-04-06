
    /********* Initial class for activation key generation. Final class is ActivationKey. *********/

import java.util.Random;

public class ActivationKey {
    public static void main(String[] args) {
        String activationKey = "";
        int j=0;
        StringBuilder key1 = generateKey(1);
        StringBuilder key2 = generateKey(2);
        key1.reverse();
        key2.reverse();

        for(int i=0;i<4;i++){
            activationKey+=key1.charAt(i);
            activationKey+=key2.charAt(j);
            j++;
        }

        StringBuilder encodedKey = Encode(activationKey);
        int half = encodedKey.length()/2;
        String[] keyParts = {encodedKey.substring(0, half),encodedKey.substring(half)};
        System.out.println("Activation Key: "+keyParts[0]+"-"+keyParts[1]);
    }

    private static StringBuilder generateKey(int keyType){
        StringBuilder key = new StringBuilder();
        Random rand = new Random();
        int bound=0, multiplier=0;

        if(keyType==1) {
            bound=417;
            multiplier=24;
        } else if(keyType==2) {
            bound=625;
            multiplier=16;
        }
        int num = rand.nextInt(bound);
        int keyNum = num*multiplier;
        if(keyNum<10) {
            key.append("000");
        } else if(keyNum<100) {
            key.append("00");
        } else if(keyNum<1000) {
            key.append("0");
        }
        key.append(keyNum);
        return key;
    }

    private static StringBuilder Encode(String key) {
        StringBuilder newKey = new StringBuilder();
        for(int i=0;i<8;i++){
            if(i%2==1) {
                newKey.append(equalCharacterOf(Integer.parseInt(String.valueOf(key.charAt(i)))));
            } else {
                newKey.append(key.charAt(i));
            }
        }
        return newKey;
    }

    private static String equalCharacterOf(int i) {
        return String.valueOf(Character.toChars(9-i+65));
    }
}
