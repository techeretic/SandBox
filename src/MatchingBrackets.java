import java.util.*;

public class MatchingBrackets {

    public static void main(String[] args) {
        List<String> brackets = new ArrayList<String>() {{
            add("{{}(");
            add("{[(])}");
            add("{{[[(())]]}}");
            add("{{[[(())]]}}");
            add("(())))(())))()");
            add("<({([)})[]>");
            add("<({()})[]>");
        }};
        for (String bracket : brackets) {
            System.out.println(bracket + " - " + (isBalanced(bracket) ? "YES" : "NO"));
        }
    }

    private static boolean isBalanced(String bracket) {
        if (bracket == null || bracket.isEmpty()) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        char [] braces = bracket.toCharArray();
        for (char c : braces) {
            if (c == '}' || c == ']' || c == ')' || c == '>') {
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
                if (c == '>') {
                    if (brackets.peek() == '<') {
                        brackets.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (c == '{' || c == '[' || c == '(' || c == '<') {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }
}