import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StoneTreasure {
	/*
	 * From
	 * https://github.com/havelessbemore/hackerrank/blob/master/algorithms/warmup/manasa-and-stones.java
	 */
	public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            short N = Short.parseShort(br.readLine());
            short A = Short.parseShort(br.readLine());
            short B = Short.parseShort(br.readLine());

            if (A > B){
                short temp = A;
                A = B;
                B = temp;
            }

            int val = ((int)--N)*A;
            short dval = (short)(B - A);

            sb.append(val);
            if (dval > 0){
                while(N-- > 0){
                    sb.append(" " + (val += dval));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
