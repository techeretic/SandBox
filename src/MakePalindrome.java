import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MakePalindrome {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String [] ip = new String[N];
        int i=0;
        while(i < N) {
        	ip[i] = br.readLine();
        	i++;
        }
        
        for(String s : ip) {
        	System.out.println(palindromeCounts(s));
        	
        }
        br.close();
    }
    private static int abs(int x){
        return x>0?x:-x;
    }

    private static int palindromeCounts(String str){
        int count = 0;
        for(int idx = 0; idx < str.length()/2; idx++) {
            count += abs(str.charAt(idx) - str.charAt(str.length()-1-idx));
        }

        return count;
    }
}
