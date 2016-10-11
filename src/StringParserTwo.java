import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by pshetye on 7/13/16.
 */
public class StringParserTwo {
    static List<String> dictionary = new ArrayList<String>() {
        {
            add("HelloWorld");
            add("HelloMars");
            add("HelloWorldMars");
            add("HiHo");
        }
    };

    static String getResults(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return "";
        }
        char[] pat = pattern.toCharArray();
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < pat.length; i++) {
            if (Character.isUpperCase(pat[i])) {
                if (i == pat.length - 1) {
                    keys.add(String.valueOf(pat[i]));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pat[i]);
                    int j = i + 1;
                    while (j < pat.length && !Character.isUpperCase(pat[j])) {
                        sb.append(pat[j]);
                        j++;
                    }
                    keys.add(sb.toString());
                }
            }
        }
        System.out.println(Arrays.toString(keys.toArray()));
        StringBuilder sb = new StringBuilder();
        for (String val : dictionary) {
            boolean decision = false;
            for (int i = 0; i < keys.size(); i++) {
                if (i == 0) {
                    decision = val.startsWith(keys.get(i));
                } else {
                    decision = val.contains(keys.get(i));
                }
                if (!decision) {
                    break;
                }
            }
            if (decision) {
                sb.append(val).append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) throws Exception {
        System.out.println(getResults("H"));
        System.out.println(getResults("HW"));
        System.out.println(getResults("Ho"));
        System.out.println(getResults("HeWorM"));
    }
}
