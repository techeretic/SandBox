import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pshetye on 10/4/16.
 */
public class MaxPalindrome {
    private static void findMaxPalindrome(int[] stream) {
        int count = 0;
        int finalChar = 0;
        List<Integer> p = new ArrayList<>();
        for (int i = 0, j = stream.length-1; i <= j;i++, j--) {
            if (i==j) {
                finalChar = stream[i];
                break;
            } else if (stream[i] == stream[j]) {
                p.add(stream[i]);
            } else {
                finalChar = stream[i];
                break;
            }
        }
        count = 2 * p.size();
        if (finalChar == 0) {
            System.out.print(Arrays.toString(p.toArray()) + ",");
        } else {
            count++;
            System.out.print(Arrays.toString(p.toArray()) + ",[" + finalChar + "],");
        }
        Collections.reverse(p);
        System.out.print(Arrays.toString(p.toArray()));
        System.out.println("\nCount = " + count);
    }

    public static void main(String [] args) {
        int [] stream = {1, 2, 4, 5, 4, 2, 1};
        findMaxPalindrome(stream);
    }
}
