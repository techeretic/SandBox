/**
 * Created by pshetye on 10/10/16.
 */
public class ReverseWords {
    private static String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        char [] chInput = input.toCharArray();
        for (int i = chInput.length-1; i >= 0; i--) {
            if (chInput[i] == ' ') {
                if (!word.toString().isEmpty()) {
                    sb.append(word.reverse());
                    word.setLength(0);
                }
                sb.append(" ");
            } else {
                word.append(chInput[i]);
            }
        }
        if (!word.toString().isEmpty()) {
            sb.append(word.reverse());
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        String originalString = "who let the dogs out";
        System.out.println("Original String : '" + originalString + "'\n Reverse : '" + reverseWords(originalString) + "'");
    }
}
