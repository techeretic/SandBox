import java.util.Arrays;

/**
 * Created by pshetye on 6/18/17.
 */
public class MaxGain {
    public static int maxGain(int[] a) {
        if (a == null) {
            return 0;
        }
        int curr = a[0], gain=0;
        for (int i : a) {
            if (i - curr > 0) {
                gain = Math.max(gain, i - curr);
            }
            curr = Math.min(curr, i);
        }
        return gain;
    }

    public static void main(String [] args) {
        int [] a = {0,50,10,100,30};
        System.out.println("Gain : " + maxGain(a) + " for " + Arrays.toString(a));
    }
}
