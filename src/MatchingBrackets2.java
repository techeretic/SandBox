import java.util.*;

public class MatchingBrackets2 {

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

    private static Map<Character, Character> sBrackets = new HashMap<>(4);
    static {
        sBrackets.put('(',')');
        sBrackets.put('[',']');
        sBrackets.put('{','}');
        sBrackets.put('<','>');
    }

    private static boolean isBalanced(String bracket) {
        if (bracket == null || bracket.isEmpty()) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        char [] braces = bracket.toCharArray();
        for (char c : braces) {
            if (sBrackets.containsKey(c)) {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (sBrackets.get(brackets.peek()).equals(c)) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}