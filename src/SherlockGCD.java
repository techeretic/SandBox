import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SherlockGCD {

	public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
        	int N = Integer.parseInt(br.readLine());
        	String [] sizes = br.readLine().split(" ");
            long[] A = new long[N];
        	HashSet<Long> hA = new HashSet<Long>();
            for(int i=0;i<N;i++) {
            	A[i] = Long.parseLong(sizes[i]);
            	if (i>0) {
            		hA.add(getGCD(A[i], A[i-1]));
            	}
            }
            if (hA.contains((long)1)) {
            	sb.append("YES");
            } else {
            	sb.append("NO");
            }
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
	}

	private static long getGCD(long a, long b) {
		long min = Math.min(a, b);
		long max = Math.max(a, b);
		
		if (max%min == 0) {
			return min;
		}
		
		return getGCD(min, max%min);
	}
}
