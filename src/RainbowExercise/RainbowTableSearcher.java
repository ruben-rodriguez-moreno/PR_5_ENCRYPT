package RainbowExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RainbowTableSearcher {
    private static final String TABLE_FILE = "src\\RainbowExercise\\rainbowTable.txt";
    private static final Map<String, String> rainbowTable = new HashMap<>();

    //Realizaremos otro programa que al pasarle un hash nos diga si lo tiene registrado y la palabra asociada.
    //Sería un miniservicio como crackstation.

    public static void main(String[] args) {
        loadRainbowTable();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un hash para hacer look up: ");
        String hashParaBuscar = scanner.nextLine();

        if (rainbowTable.containsKey(hashParaBuscar)) {
            System.out.println("Contraseña encontrada: " + rainbowTable.get(hashParaBuscar));
        } else {
            System.out.println("Hash no encontrado en la tabla.");
        }
        scanner.close();
    }

    private static void loadRainbowTable() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TABLE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(":");
                if (partes.length == 2) {
                    rainbowTable.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}