import java.util.HashMap;
import java.util.Map;

/**
 * Created by pshetye on 6/15/17.
 */
public class Uniques {
    public static void main(String [] args) {
        int [] A = {1,2,3,4,1,2,4,3,5};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, ++count);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
