import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by pshetye on 6/14/17.
 */
public class kdiffpairs {
    static Integer [] arr = {1, 7, 5, 9 , 2, 12, 3, 11};
//    public static void main(String [] args) {
//        final int diff = 2;
//        int count = 0;
//        for (int i=0;i<arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (Math.abs(arr[i] - arr[j]) == diff) {
//                    System.out.print(arr[i] + " - " + arr[j] + "  ");
//                }
//                System.out.println(++count + " -- ");
//            }
//        }
//    }

    public static void main(String [] args) {
        Hashtable<Integer, Integer> table = new Hashtable<>(arr.length);
        Set<Integer> set = new LinkedHashSet<>();
        final int diff = 2;
        for (int i : arr) {
            table.put(i-diff, i);
        }
        set.addAll(Arrays.asList(arr));
        for (int i : arr) {
            if (table.containsKey(i)) {
                System.out.print(i + " - " + table.get(i) + "  ");
            }
        }
        System.out.println();
        for (int i : arr) {
            if (set.contains(i-diff)) {
                System.out.print(i + " - " + (i-diff) + "  ");
            }
        }
    }
}
