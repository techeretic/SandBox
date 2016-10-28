import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatchingBrackets {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        List<String> brackets = new ArrayList<>(t);
//        for(int a0 = 0; a0 < t; a0++){
//            brackets.add(in.next());
//        }
        List<String> brackets = new ArrayList<String>() {{
            add("{{}(");
            add("{[(])}");
            add("{{[[(())]]}}");
            add("{{[[(())]]}}");
        }};
        for (String bracket : brackets) {
            System.out.println(isBalanced(bracket) ? "YES" : "NO");
        }
    }

    private static boolean isBalanced(String bracket) {
        if (bracket == null || bracket.isEmpty()) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        char [] braces = bracket.toCharArray();
        for (char c : braces) {
            if (c == '}' || c == ']' || c == ')') {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (c == '}') {
                    if (brackets.peek() == '{') {
                        brackets.pop();
                    } else {
                        return false;
                    }
                }
                if (c == ']') {
                    if (brackets.peek() == '[') {
                        brackets.pop();
                    } else {
                        return false;
                    }
                }
                if (c == ')') {
                    if (brackets.peek() == '(') {
                        brackets.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (c == '{' || c == '[' || c == '(') {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }
}