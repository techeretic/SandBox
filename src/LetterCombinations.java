import java.util.LinkedList;
import java.util.List;

/**
 * Created by prathamesh on 6/25/17.
 */
public class LetterCombinations {

    private static String [] digitMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String [] args) {
        System.out.println(letterCombinations(new int[]{2, 2, 8}));
    }

    private static List<String> letterCombinations(int [] digits) {
        List<String> ans = new LinkedList<>();
        letterCombinations("", ans, digits, 0);
        return ans;
    }

    private static void letterCombinations(String current, List<String> combos, int [] digits, int index) {
        if (current.length() == digits.length) {
            combos.add(current);
            return;
        }
        if (index == digits.length) {
            return;
        }
        for (char c : digitMap[digits[index]].toCharArray()) {
            letterCombinations(current + c, combos, digits, index+1);
        }
    }
}
