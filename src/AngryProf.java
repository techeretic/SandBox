import java.io.BufferedReader;
import java.io.InputStreamReader;


public class AngryProf {

	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(byte T = Byte.parseByte(in.readLine()); T > 0; --T){
			String[] ip = in.readLine().split(" ");
			int N = Integer.parseInt(ip[0]);
			int K = Integer.parseInt(ip[1]);
			int num, count = 0;
			ip = in.readLine().split(" ");
			for(int i=0;i<N;i++) {
				num = Integer.parseInt(ip[i]);
				if (num <= 0) {
					count++;
				}
			}
			if (count >= K) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
