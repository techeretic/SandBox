import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class StoneTreasure {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. *//* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stone [] stones = new Stone[T];
        int i=0;
        while(i < T) {
        	stones[i] = new Stone();
        	stones[i].N = Integer.parseInt(br.readLine());
        	stones[i].a = Integer.parseInt(br.readLine());
        	stones[i].b = Integer.parseInt(br.readLine());
        	i++;
        }
    }
    
    private static class Stone {
    	int N;
    	int a;
    	int b;
    }
    
    private static void getEnds(Stone S) {
    	Set<Integer> result = new HashSet<Integer>();
    	int [] temp = new int[S.N];
    	int finalVal = 0;
    	while(finalVal < (S.N-1)*S.b) {
    		temp[0] = 0;
    	}
    }
    
    private static int getEnd(Stone s, int index, int val) {
    	if (s.N-1 == index) {
    		return val;
    	}
    	
    }
}
