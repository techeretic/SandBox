import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pshetye on 10/12/16.
 */
public class SparseDS {

    /**

     There are  strings. Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

     Input Format

     The first line contains , the number of strings.
     The next  lines each contain a string.
     The nd line contains , the number of queries.
     The following  lines each contain a query string.

     Constraints
     1 <= N <= 1000
     1 <= Q <= 1000
     1 <= string length <= 20

     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>(N);
        String [] dict = new String[N];
        for (int i=0; i<N; i++) {
            dict[i] = br.readLine();
            if (map.containsKey(dict[i])) {
                map.put(dict[i], map.get(dict[i]) + 1);
            } else {
                map.put(dict[i], 1);
            }
        }
        int Q = Integer.parseInt(br.readLine());
        String [] keys = new String[Q];
        for (int i=0; i<Q; i++) {
            keys[i] = br.readLine();
        }
        for (String key : keys) {
            if (map.containsKey(key)) {
                System.out.println(map.get(key));
            } else {
                System.out.println("0");
            }
        }
    }
}
