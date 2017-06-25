import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by prathamesh on 6/25/17.
 */
public class MaxSlidingWindow {

    public static void main(String [] args) {
        int [] ip = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow1(ip, k)));
//        System.out.println(Arrays.toString(maxSlidingWindow(ip, k)));
    }

    private static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int [] res = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0; i< nums.length; i++) {
            int windowStart = i-k+1;
            if (!q.isEmpty() && q.peek() < windowStart) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peek()] < nums[i]) {
                q.pollLast();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k-1) {
                res[j++] = nums[q.peek()];
            }
        }
        return res;
    }

    private static int[] maxSlidingWindow(int[] n, int k) {
        if (n == null || n.length < 1) {
            return new int[0];
        }
        if (n.length == 1 || k == 1) {
            return n;
        }
        int [] res = new int[n.length - k + 1];
        int max = 0;
        int start = 0, i = 0;
        for (int j = 0; j< n.length;j++) {
            if (j-start == k-1) {
                if (max >= start && max <= j) {
                    res[i++] = n[max];
                    start++;
                } else {

                }
            } else {
                if (n[max] < n[j]) {
                    max = j;
                }
            }
        }
        return res;
    }
}
