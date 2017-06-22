/**
 * Created by pshetye on 6/17/17.
 */
public class PalindromeCheck {
    public static boolean isStringPalindrome(String str){
        if (str == null || str.isEmpty()) {
            return true;
        }
        int length = str.length();
        for (int i = 0, j=length-1; i < length/2 && j > length/2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {
        System.out.println(isStringPalindrome("not a palindrome"));
    }
}
