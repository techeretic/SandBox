import java.util.Arrays;

public class WildcardMatching {
    public static void main(String [] args) {
        isMatch("acdcb", "a*c?b");
    }

    public static boolean isMatch(String s, String p) {

        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (s.equals(p) || p.equals("*")) {
            return true;
        }

        boolean [][] dp = new boolean [p.length() + 1][s.length() + 1];

        dp[0][0] = true;

        for (int pi = 1; pi < p.length() + 1; pi++) {

            switch(p.charAt(pi - 1)) {
                case '*': {
                    int si = 1;

                    while(!dp[pi - 1][si - 1] && si < s.length() + 1) {
                        si++;
                    }

                    dp[pi][si - 1] = dp[pi - 1][si-1];

                    while(si < s.length() + 1) {
                        dp[pi][si++] = true;
                    }
                    break;
                }
                case '?': {
                    for (int si = 1; si < s.length() + 1; si++) {
                        dp[pi][si] = dp[pi-1][si-1];
                    }
                    break;
                }
                default: {
                    for (int si = 1; si < s.length() + 1; si++) {
                        dp[pi][si] = dp[pi - 1][si - 1] && p.charAt(pi - 1) == s.charAt(si - 1);
                    }
                }
            }

            System.out.print("\n\t\t");
            for(char c : s.toCharArray()) {
                System.out.print(c + "\t\t");
            }
            System.out.println();
            int i = -1;
            for (boolean [] d : dp) {
                if (i < 0) {
                    System.out.println("  " + Arrays.toString(d));
                } else {
                    System.out.println(p.charAt(i) + " " + Arrays.toString(d));
                }
                i++;
            }
            System.out.println();
        }

        return dp[p.length()][s.length()];
    }
}
