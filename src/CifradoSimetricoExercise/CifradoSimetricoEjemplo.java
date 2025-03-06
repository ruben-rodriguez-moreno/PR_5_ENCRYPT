package CifradoSimetricoExercise;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CifradoSimetricoEjemplo {
    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";
    private static final String KEY_ALGORITMO = "AES";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la contraseña: ");
        String password = scanner.nextLine();

        System.out.print("Introduce el texto para encriptar: ");
        String textToEncrypt = scanner.nextLine();

        byte[] keyBytes = new byte[16];
        System.arraycopy(password.getBytes(), 0, keyBytes, 0, Math.min(password.getBytes().length, 16));

        SecretKey secretKey = new SecretKeySpec(keyBytes, KEY_ALGORITMO);

        // Encripta
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(textToEncrypt.getBytes());

        // Desencripta
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);

        System.out.println("Texto original: " + textToEncrypt);
        System.out.println("Encriptado \\(base64\\): " + java.util.Base64.getEncoder().encodeToString(encryptedBytes));
        System.out.println("Texto desencriptado: " + decryptedText);

        scanner.close();
    }
}