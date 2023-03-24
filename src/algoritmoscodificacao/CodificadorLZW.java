package algoritmoscodificacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maico-Abu
 */
public class CodificadorLZW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String input = "ABABABC";
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> encoded = new ArrayList<>();
        int dictSize = 122;
        for (int i = 0; i < 122; i++) {
            dictionary.put(Character.toString((char) i), i);
        }
        String current = "";
        for (char c : input.toCharArray()) {
            String combined = current + c;
            if (dictionary.containsKey(combined)) {
                current = combined;
            } else {
                encoded.add(dictionary.get(current));
                dictionary.put(combined, dictSize++);
                current = Character.toString(c);
            }
        }
        if (!current.equals("")) {
            encoded.add(dictionary.get(current));
        }
        System.out.println(encoded);
    }
}
