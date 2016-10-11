import java.util.*;

/**
 * Created by pshetye on 7/13/16.
 */
public class StringParser {
    static List<String> dictionary = new ArrayList<String>() {
        {
            add("HelloWorld");
            add("HelloMars");
            add("HelloWorldMars");
            add("HiHo");
        }
    };

    static String getResults(String pattern, Map<Integer, List<String>> dict) {
        if (pattern == null || pattern.isEmpty()) {
            return "";
        }
        char[] pat = pattern.toCharArray();
        List<String> keys = new ArrayList<>();
//        for (int i = 0;i<pat.length;i++) {
//            if (Character.isUpperCase(pat[i])) {
//                if (i == pat.length -1) {
//                    keys.add(String.valueOf(pat[i]));
//                } else {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(pat[i]);
//                    int j = i + 1;
//                    while (j < pat.length && !Character.isUpperCase(pat[j])) {
//                        sb.append(pat[j]);
//                        j++;
//                    }
//                    keys.add(sb.toString());
//                }
//            }
//        }
        System.out.println(Arrays.toString(keys.toArray()));
        StringBuilder sb = new StringBuilder();
//        for (String key : keys) {
//            for (String val : dictionary) {
//                if (val.startsWith(key)) {
//                    sb.append(val).append(",");
//                }
//            }
//        }
//        for (String val : dictionary) {
//            for (String key : keys) {
//                if (val.contains(key)) {
//                    sb.append(val).append(",");
//                }
//            }
//        }

        for (String key : keys) {
            for (Map.Entry<Integer, List<String>> entry : dict.entrySet()) {
                for (String val : entry.getValue()) {
                    if (val.startsWith(key)) {
                        sb.append(val).append(",");
                    }
                }
            }
        }

        return sb.toString();
    }

    static Map<Integer, List<String>> splitDictionary(List<String> ip) {
        Map<Integer, List<String>> result = new HashMap<>();
        for (int index = 0; index < ip.size(); index++) {
            String s = ip.get(index);
            char [] pat = s.toCharArray();
            for (int i = 0; i < pat.length; i++) {
                if (Character.isUpperCase(pat[i])) {
                    if (i == pat.length - 1) {
                        if (result.containsKey(index)) {
                            result.get(index).add(String.valueOf(pat[i]));
                        } else {
                            List<String> values = new ArrayList<>();
                            values.add(String.valueOf(pat[i]));
                            result.put(index, values);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(pat[i]);
                        int j = i + 1;
                        while (j < pat.length && !Character.isUpperCase(pat[j])) {
                            sb.append(pat[j]);
                            j++;
                        }
                        if (result.containsKey(index)) {
                            result.get(index).add(sb.toString());
                        } else {
                            List<String> values = new ArrayList<>();
                            values.add(sb.toString());
                            result.put(index, values);
                        }
                    }
                }
            }
        }
        return result;
    }


    public static void main(String [] args) throws Exception {
        Map<Integer, List<String>> dict = splitDictionary(dictionary);
        System.out.println(getResults("H", dict));
        System.out.println(getResults("HW", dict));
        System.out.println(getResults("Ho", dict));
        System.out.println(getResults("HeWorM", dict));
    }
}
