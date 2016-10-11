/**
 * Created by pshetye on 7/12/16.
 */
public class ReverseVowels {
    private static String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = str.length;
        while(i<j) {
            if (isVowel(str[i])) {
                while (!isVowel(str[--j]) && i < j) {
                }
                char a = str[i];
                str[i] = str[j];
                str[j] = a;
            }
            i++;
        }
        return String.valueOf(str);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels(".a"));
        System.out.println(reverseVowels("ai"));
        System.out.println(reverseVowels("Aa"));
        System.out.println(reverseVowels("a."));
        System.out.println(reverseVowels("race car"));
    }
}
