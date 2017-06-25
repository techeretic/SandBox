import java.util.*;

/**
 * Created by pshetye on 10/10/16.
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 9, 12, 7, 8, 2, 11};
        int [][] arr = {{1,0,0},{0,0,1}};
        int k = 4;
        System.out.println(k+"th largest number is "+kthLargest(array,k));
        System.out.println(k+" largest numbers are "+kLargest(array,k));
//        flipHorizontalAxis(arr);
    }

    public static String kLargest(int [] arr, int k) {
        Set<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : arr) {
            treeSet.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : treeSet) {
            if (k == 0) {
                break;
            }
            sb.append(i);
            if (k > 1) {
                sb.append(", ");
            }
            k--;
        }
        return sb.toString();
    }

    public static int kthLargest(int[] array, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(array.length);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(array.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if(k < 1 || k >= array.length){
            System.out.println("Array size is smaller than k.");
            return 0;
        }
        for(int i=0;i<array.length;i++){
            queue.add(array[i]);
            queue2.add(array[i]);
//            System.out.println("\n array[i] = " + array[i] + " - " + Arrays.toString(queue.toArray()));
//            System.out.println("\n array[i] = " + array[i] + " - " + Arrays.toString(queue2.toArray()));
        }
        int returnVal = (Integer) queue.toArray()[k-1];

//        System.out.println(queue.poll() + " queue.poll()");
//        while(!queue.isEmpty()) {
//            System.out.println("queue values : " + queue.remove());
//        }
        return returnVal;
    }

    public static void flipHorizontalAxis(int[][] matrix) {
        int i = matrix.length - 1;
        int k = 0;
        for (int [] arr1 : matrix) {
            System.out.println(Arrays.toString(arr1));
        }
        while (i >= 0 && k < matrix.length) {
            for (int j = 0; j< matrix[i].length; j++) {
                System.out.println("Swapping : " + matrix[i][j] + " & " + matrix[k][j]);
                int val = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = val;

                for (int [] arr1 : matrix) {
                    System.out.println(Arrays.toString(arr1));
                }
            }
            i--;
            k++;
        }
    }
}
