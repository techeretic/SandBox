import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by pshetye on 6/15/17.
 */
public class Dupes {
    public static void main(String[] args) {
        int [] input = {1,3, 4, 3,4,2,1,2,4};
        Set<Integer> dupes = new LinkedHashSet<>(input.length/2);

        Set<Integer> set = new LinkedHashSet<>();
        for (int i : input) {
            if (set.contains(i)) {
                dupes.add(i);
            } else {
                set.add(i);
            }
        }
        System.out.println(Arrays.toString(dupes.toArray()));
    }
}
