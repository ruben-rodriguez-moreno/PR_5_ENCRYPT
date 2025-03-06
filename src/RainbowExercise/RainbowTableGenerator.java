package RainbowExercise;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class RainbowTableGenerator {
    private static final String HASH_ALGORITMO = "SHA-256";

    //Haremos un programa que a partir de un archivo de texto con una lista de palabras (posibles password) genere el hash
    //y lo guarde en otro archivo, que será la rainbow table.

    public static void main(String[] args) {
        String inputFile = "src\\RainbowExercise\\passwords.txt";
        String outputFile = "src\\RainbowExercise\\rainbowTable.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String password;
            while ((password = reader.readLine()) != null) {
                String hash = generarHash(password);
                writer.write(hash + ":" + password);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generarHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITMO);
            byte[] hashedBytes = digest.digest(input.getBytes());
            return byteArrayToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String byteArrayToHex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String hexString = formatter.toString();
        formatter.close();
        return hexString;
    }
}