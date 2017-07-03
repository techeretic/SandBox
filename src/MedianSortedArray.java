/**
 * Created by prathamesh on 7/2/17.
 */
public class MedianSortedArray {

    public static void main(String [] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }

    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        int [] sort;
        if (num1.length == 0 && num2.length == 0) {
            return 0D;
        } else if (num1.length == 0) {
            sort = num2;
        } else if (num2.length == 0) {
            sort = num1;
        } else {
            sort = new int [num1.length + num2.length];
            int i=0, j=0, k=0;
            while (true) {
                if (i < num1.length
                        && ((j < num2.length && num1[i] <= num2[j]) ||
                        (j == num2.length))) {
                    sort[k++] = num1[i++];
                }
                if (j < num2.length
                        && ((i < num1.length && num2[j] < num1[i]) ||
                        (i == num1.length))) {
                    sort[k++] = num2[j++];
                }
                if (i == num1.length && j == num2.length) {
                    break;
                }
            }
        }
        if (sort.length == 1) {
            return Double.valueOf(sort[0]);
        }
        double median;
        int mid = (sort.length / 2) - 1;
        if (sort.length == 2) {
            mid = 0;
        }
        if (sort.length % 2 == 0) {
            double sum = (sort[mid] + sort[mid+1]);
            median = sum / 2;
        } else {
            median = sort[mid];
        }
        return median;
    }
}
