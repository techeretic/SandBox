import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Sticks {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] ip = in.readLine().split(" ");
		int[] a = new int[N];

		for(int i=0;i<ip.length;i++) {
			a[i] = Integer.parseInt(ip[i]);
		}
		Arrays.sort(a);
		for(int i = 0;i<N;i++) {
			if (a[i] == 0) {
				continue;
			}
			for(int j=i+1;j<N;j++) {
				a[j] -= a[i];
			}
			System.out.println(N-i);
		}
	}

}
