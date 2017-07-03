import java.util.*;

/**
 * Created by prathamesh on 7/2/17.
 */
public class FirstUniqueChar {

    public static void main(String [] args) {
        System.out.println(firstUniqChar("dbddaadbb"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Set<Character> u = new HashSet<>();
        Queue<Integer> indices = new LinkedList<>();
        int index = Integer.MAX_VALUE;
        for (int i=0;i<s.length(); i++) {
            if (!u.contains(s.charAt(i))) {
                indices.offer(i);
                if (index == -1) {
                    index = i;
                } else {
                    index = Math.min(index, i);
                }
                u.add(s.charAt(i));
            } else {
                if (index != -1 && s.charAt(index) == s.charAt(i)) {
                    if (indices.isEmpty()) {
                        index = -1;
                    } else {
                        indices.poll();
                        if (!indices.isEmpty()) {
                            index = indices.peek();
                        } else {
                            index = -1;
                        }
                    }
                }
            }
        }
        return index;
    }
}
