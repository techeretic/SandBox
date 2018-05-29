import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by pshetye on 10/4/16.
 */
public class TwoSum {

    private Set<Integer> store = new HashSet<>();

    public void store(int num) {
        store.add(num);
    }

    public boolean test(int num) {
        int diff;
        for(int i : store) {
            diff = Math.abs(i-num);
            if (store.contains(diff) && i+diff == num) {
                System.out.println(i + " + " + diff + " = " + num);
            }
        }
        return false;
    }

    public static void main(String [] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.store(2);
        twoSum.store(3);
        twoSum.store(4);
        twoSum.store(5);
        twoSum.store(6);
        twoSum.store(10);
        twoSum.store(11);
        twoSum.store(12);
        twoSum.store(1);
        twoSum.test(17);
    }
}
