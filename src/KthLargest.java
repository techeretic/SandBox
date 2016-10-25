import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pshetye on 10/10/16.
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 9, 1};
        int k = 3;
        System.out.println(k+"th largest number is "+kthLargest(array,k));
    }

    public static int kthLargest(int[] array, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(array.length);
        if(k < 1 || k > array.length){
            System.out.println("Array size is smaller than k.");
            return 0;
        }
        for(int i=0;i<array.length;i++){
            queue.add(array[i]);
            System.out.println("\n array[i] = " + array[i] + " - " + Arrays.toString(queue.toArray()));
        }
        int returnVal = (Integer) queue.toArray()[array.length-k-1];
        while(!queue.isEmpty()) {
            System.out.println("queue values : " + queue.remove());
        }
        return returnVal;
    }

}
