package ua.nure.shamrai.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] mbytes = md.digest(input.getBytes());
        StringBuilder strb = new StringBuilder();
        for(byte i : mbytes){
          strb.append(String.format("%02X", i));
        }
        return strb.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
      System.out.println(hash("asdf", "MD5"));
      System.out.println(hash("asdf", "SHA-256"));
    }
}
