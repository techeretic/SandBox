import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by pshetye on 7/12/16.
 */
public class RadixSort {
    int[] input = new int[]{45, 615, 785, 984, 366, 40, 31, 89, 125, 200, 2, 132, 456, 23, 678, 56, 789, 525, 968};

    private void radixSort(int[] arr) {
        int radix = 10;
        int base = 1;
        Limits limits = getLimits(arr);
        System.out.println("\n\nMAX = " + limits.getMax() + " MIN = " + limits.getMin());

        while(abs(limits.getMax() / base) > 0) {
            int []indices = new int[10];
            int []result = new int[arr.length];
            int i;
            for (i = 0; i < arr.length; i++) {
                indices[(abs(arr[i]) / base) % radix]++;
            }
            for (i = 1; i < 10; i++) {
                indices[i] += indices[i-1];
            }
            System.out.println(Arrays.toString(indices));
            for (i = arr.length - 1; i >= 0; i--) {
//            for (i = 0; i < arr.length; i++) {
                int index = (abs(arr[i]) / base) % radix;
                int bucketIndex = --indices[index];
                System.out.println(index + " - " + bucketIndex + " - arr[i] = " + arr[i]);
                result[bucketIndex] = arr[i];
            }
            System.out.println(Arrays.toString(result));
            arr = Arrays.copyOf(result, result.length);
            base *= 10;
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(indices));
        }
    }

    private Limits getLimits(int[] arr) {
        Limits limits = new Limits();
        limits.setMax(arr[0]);
        limits.setMin(arr[0]);
        for (int i=1; i < arr.length; i++) {
            if (limits.getMax() < arr[i]) {
                limits.setMax(arr[i]);
            }
            if (limits.getMin() > arr[i]) {
                limits.setMin(arr[i]);
            }
        }
        return limits;
    }

    private static class Limits {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static void main(String[] args) throws Exception {
        RadixSort sort = new RadixSort();
        sort.radixSort(sort.input);

//        sortMethod(sort.input);
    }
}
