import java.util.LinkedList;
import java.util.List;

/**
 * Created by prathamesh on 6/25/17.
 */
public class LetterCombinations {

    public static void main(String [] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        if (ans.size() == 1 && ans.get(0) == "") {
            ans.remove("");
        }
        return ans;
    }
}
