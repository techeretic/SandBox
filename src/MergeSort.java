import java.util.Arrays;

/**
 * Created by pshetye on 6/18/17.
 */
public class MergeSort {
    private static void mergeSort(int [] arr) {
        int [] split = new int[arr.length];
        mergeSort(arr, split, 0, arr.length-1);
    }

    private static void mergeSort(int [] arr, int [] split, int start, int end) {
        if (end > start) {
            System.out.println("Hop : " + ++count + " & Array : " + Arrays.toString(arr));
            int mid = (start + end) / 2;
            mergeSort(arr, split, start, mid);
            mergeSort(arr, split, mid + 1, end);
            merge(arr, split, start, end);
        }
    }

    private static void merge(int [] arr, int [] split, int start, int end) {
        System.arraycopy(arr, start, split, start, end - start + 1);
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, k = start;

        while(true) {
            if ((i < mid+1 && j < end+1 && split[i] <= split[j]) || (j == end+1 && i < mid+1)) {
                arr[k++] = split[i++];
            }
            if ((i < mid+1 && j < end+1 && split[i] > split[j]) || (i == mid+1 && j < end+1)) {
                arr[k++] = split[j++];
            }
            if (i == mid+1 && j == end+1) {
                break;
            }
        }
    }

    private static int count = 0;

    public static void main(String [] args) {
        int [] arr = {15, 89,26,47,25,23,21,5,65, 29,34,5,6,3,43,34,37,53,45,34,52,38,24,23, 14,23,43, 75,46,41, 56,3,29,44,4};
        System.out.println("Before : Size = : " + arr.length + " & Array : " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After  : Size = : " + arr.length + " & Array : " + Arrays.toString(arr));
    }
}
