package project;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Decrypt {

    static Cipher DESCipher;
    static KeyGenerator KEY_generator;
    static SecretKey myDesKey;
    static byte[] textEncrypted;


    public Decrypt() {
    }

    public String Decrypt(byte[] input, String sk_string) {
        try {
            //Convert String to secret key
            byte[] decodedKey = Base64.getDecoder().decode(sk_string);
            SecretKeySpec originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
            //init the Mode
            DESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the same cipher for decryption
            DESCipher.init(Cipher.DECRYPT_MODE, originalKey);


            // Decrypt the text
            byte[] textDecrypted = DESCipher.doFinal(input);

            //Prints the text that has been decrypted
            //System.out.println("Text Decryted : " + new String(textDecrypted));

            String s = new String(textDecrypted);
            return s;

        } catch (IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
