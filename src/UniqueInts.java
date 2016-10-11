import java.util.*;

/**
 * Created by pshetye on 10/2/16.
 */
public class UniqueInts {

    public static void main(String [] args) {
        UniqueInts uniqueInts = new UniqueInts();
        int [] a1 = {1,2,3,5,2,2,3,4};
        int [] a2 = {1,2,2,2,3,3,4,5};
        int [] a3 = {1,1,1,1,2,2,2,3,3,4,4,5,5,5,5,5,6,7,7,7,7,8};

        uniqueInts.once_integers(a1);
        System.out.println();
        uniqueInts.once_integer_sorted(a2);
        System.out.println();
        uniqueInts.once_integers(a3);
        System.out.println();
        uniqueInts.once_integer_sorted(a3);
    }

    public void once_integers(int nums[]) {
        Map<Integer, Integer> store = new HashMap<>();
        for (Integer i : nums) {
            if (store.containsKey(i)) {
                store.put(i, store.get(i) + 1);
            } else {
                store.put(i, 1);
            }
        }
        for(Map.Entry<Integer, Integer> e : store.entrySet()) {
            if (e.getValue() == 1) {
                System.out.print(e.getKey() + " - ");
            }
        }
    }

    public void once_integer_sorted(int nums[] ) {
        int count = 0;
        for (int i = 0; i< nums.length; i++) {
            if (i == nums.length - 1) {
                if (count == 0) {
                    System.out.print(nums[i] + " - ");
                }
                break;
            }
            if (nums[i] != nums[i+1]) {
                if (count == 0) {
                    System.out.print(nums[i] + " - ");
                }
                count = 0;
            } else {
                count++;
            }
        }
    }
}
