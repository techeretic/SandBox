import java.util.Stack;

/**
 * Created by pshetye on 10/11/16.
 */
public class Balancer {

    public static String balance(String str) {
        Stack<Integer> indices = new Stack<>();
        char [] arr = str.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == '(') {
                indices.push(i);
            } else if (arr[i] == ')') {
                if (!indices.isEmpty() && arr[indices.peek()] == '(') {
                    indices.pop();
                } else {
                    indices.push(i);
                }
            }
        }
        if (indices.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            if (!indices.isEmpty()) {
                if (i != indices.peek()) {
                    sb.append(arr[i]);
                } else {
                    indices.pop();
                }
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String [] args) {
        String original = "(())))(())))()";
        System.out.print("Original = " + original + "\nBalanced = " + balance(original));
    }
}
