import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathamesh on 6/24/17.
 */
public class AnagramSubString {

    public static void main(String [] args) {
        System.out.println(findAnagrams("cebaebabeacd", "abc").toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int [] chars = new int[26];
        List<Integer> results = new ArrayList<>();

        for (char c : p.toLowerCase().toCharArray()) {
            chars[index(c)]++;
        }

        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (end - start == p.length()) {
                if (chars[index(s.charAt(start))]++ >= 0) {
                    count++;
                }
                start++;
            }
//            if (end - start == p.length() && chars[index(s.charAt(start++))]++ >= 0) {
//                count++;
//            }
            if (--chars[index(s.charAt(end))] >= 0) {
                count--;
            }
            end++;
            if (count == 0) {
                results.add(start);
            }
        }

        return results;
    }

    private static int index(char c) {
        return c-'a';
    }
}
