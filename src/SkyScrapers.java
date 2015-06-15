import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SkyScrapers {

	public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] num = br.readLine().split(" ");
        int [] arr = new int [N];
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        int count = 0;
        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if (arr[i] < arr[j]) {
                    break;
                }
                if (arr[i] == arr[j]) {
                    System.out.println(i + " , " + j);
                    count++;
                }
            }
        }

        System.out.println(count*2);
	}

}
