import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pshetye on 7/3/17.
 */
public class AnagramSubstring2 {

    public static void main(String [] args) {
        System.out.println(subStrings("cebaebacbeacd", "abc").toString());
    }


    private static List<String> subStrings(String s, String p) {
        List<String> results = new ArrayList<>();
        char [] pChar = p.toCharArray();
        Arrays.sort(pChar);
        String source = new String(pChar);
        for (int i=0; i<s.length() - p.length(); i++) {
            char [] sChar = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(sChar);
            System.out.println(Arrays.toString(sChar));
            if (source.equals(new String(sChar))) {
                System.out.println(i);
                results.add(s.substring(i, i+p.length()));
            }
        }
        return results;
    }

}
