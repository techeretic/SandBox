import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by prathamesh on 7/2/17.
 */
public class LongestSubstring {

    public static void main(String [] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(s.length(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Set<Character> characters = new HashSet<>(s.length());
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (characters.contains(s.charAt(i))) {
                maxHeap.add(++length);
                length = 0;
            } else {
                length++;
            }
            characters.add(s.charAt(i));
        }
        if (maxHeap.isEmpty()) {
            return 1;
        }
        return maxHeap.poll();
    }
}
