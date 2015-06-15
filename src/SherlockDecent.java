import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SherlockDecent {

	public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
        	long N = Integer.parseInt(br.readLine());
        	if (N < 5 && N != 3) {
        		sb.append(-1);
            	sb.append("\n");
        		continue;
        	}
        	sb.append(generateNumber(N));
        	sb.append("\n");
        }
        System.out.println(sb.toString());
	}
	
	private static String generateNumber(long N) {
		if (N < 5 && N != 3) {
			return "-1";
		}
		StringBuffer sb = new StringBuffer();
		for(long i = N; i >= 0; i-=5) {
			if (i < 5 && i != 3 && i > 0) {
				return "-1";
			}
			if (i%3 == 0) {
				for(int j=0;j<i;j+=3) {
					sb.insert(0, "555");
				}
				break;
			}
			sb.append("33333");
		}
		return sb.toString();
	}
}
