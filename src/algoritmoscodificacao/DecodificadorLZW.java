
package algoritmoscodificacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maico-Abu
 */

public class DecodificadorLZW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   List<Integer> encoded = new ArrayList<>();
        encoded.add(65);
        encoded.add(66);
        encoded.add(122);
        encoded.add(122);
        encoded.add(67);

        Map<Integer, String> dictionary = new HashMap<>();
        int dictSize = 122;
        for (int i = 0; i < 122; i++) {
            dictionary.put(i, Character.toString((char) i));
        }
        String current = Character.toString((char) (int) encoded.remove(0));
        String decoded = current;
        for (int code : encoded) {
            String entry;
            if (dictionary.containsKey(code)) {
                entry = dictionary.get(code);
            } else if (code == dictSize) {
                entry = current + current.charAt(0);
            } else {
                throw new IllegalArgumentException("");
            }
            decoded += entry;
            dictionary.put(dictSize++, current + entry.charAt(0));
            current = entry;
        }
        System.out.println(decoded);
    }
}
