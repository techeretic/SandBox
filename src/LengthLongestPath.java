/**
 * Created by pshetye on 7/16/17.
 */
public class LengthLongestPath {

    private static int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths) {
            int level = s.lastIndexOf("\t") + 1;
            stack[level + 1] = stack[level] + s.length() - level + 1;
            int currentLength = stack[level + 1];
            if(s.contains(".")) {
                maxLen = Math.max(maxLen, currentLength -1);
            }
        }
        return maxLen;
    }

    public static void main(String [] args) {
        System.out.print(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
