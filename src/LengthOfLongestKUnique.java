import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by pshetye on 7/16/17.
 */
public class LengthOfLongestKUnique {
    private static int lengthOfLongestSubstringKDistinct(String input, int k) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.length() < k) {
            return input.length();
        }
        Set<Character> set = new LinkedHashSet<>(k);
        int offset = 0, maxLen = k;
        for (int i = 0; i<input.length(); i++) {
            if (!set.contains(input.charAt(i))) {
                if (set.size() < k) {
                    set.add(input.charAt(i));
                } else {
                    int j = offset;
                    while(input.charAt(j) != input.charAt(i)) {
                        set.remove(input.charAt(j));
                    }
                    set.add(input.charAt(i));
                    offset++;
                }
            }
            if (set.size() == k) {
                System.out.println(input.substring(offset, i+1));
                maxLen = Math.max(maxLen, i - offset + 1);
            }
        }
        return maxLen;
    }

    public static void main(String [] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2));
    }
}
