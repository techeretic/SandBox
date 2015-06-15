import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BetweenSquares {

	public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long startTime = System.currentTimeMillis();
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String [] sizes = br.readLine().split(" ");
            long A = Long.parseLong(sizes[0]);
            long B = Long.parseLong(sizes[1]);
            double sA = Math.sqrt(A);
            double sB = Math.sqrt(B);
            long resA = (long) sA;
            long resB = (long) sB;
            if (sA % 1 == 0) {
            	resA -= 1;
            }
            if (resA == resB) {
            	sb.append(0);
            	sb.append("\n");
            } else {
            	sb.append((resB - resA));
            	sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
        System.out.println("\nTime Taken : " + (System.currentTimeMillis()-startTime) + "s");
	}

}
