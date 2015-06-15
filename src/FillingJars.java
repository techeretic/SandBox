import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FillingJars {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] ip = br.readLine().split(" ");
		long N = Long.parseLong(ip[0]);
		long M = Long.parseLong(ip[1]);
		long total = 0;
		for(long i=0;i<M;i++) {
			ip = br.readLine().split(" ");
			long a = Long.parseLong(ip[0]);
			long b = Long.parseLong(ip[1]);
			long k = Long.parseLong(ip[2]);
			if (a > b) {
				Long temp = a;
				a = b;
				b = temp;
			}
			total += (k*(b-a+1));
		}
		System.out.println(String.valueOf(total/N));
	}

}
