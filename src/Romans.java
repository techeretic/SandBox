import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Romans {
    private static Map<Character, Integer> romans;
    static {
        romans = new HashMap<Character, Integer>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;

        for (int i=s.length() - 1; i >= 0; i--) {
            if (i-1 >= 0 && romans.get(s.charAt(i)) > romans.get(s.charAt(i-1))) {
                result += (romans.get(s.charAt(i)) - romans.get(s.charAt(i-1)));
            } else {
                result += romans.get(s.charAt(i));
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        int ret = new Romans().romanToInt("IV");

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}