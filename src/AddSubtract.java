import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AddSubtract {

	public final static int ADD_COST=3;
	public final static int SUB_COST=2;
	public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        TestCases [] t_arr = new TestCases[T];
	    for(int i=0;i<T;i++) {
	    	t_arr[i] = new TestCases();
	        line = br.readLine();
	        String[] parsed = line.split(" ");
	        t_arr[i].N = Integer.parseInt(parsed[0]);
	        t_arr[i].K = Integer.parseInt(parsed[1]);
	        line = br.readLine();
	        parsed = line.split(" ");
	        t_arr[i].arr = new int[t_arr[i].N];
	        for(int j=0;j<t_arr[i].N;j++){
	        	t_arr[i].arr[j] = Integer.parseInt(parsed[j]);
	        }
	    }
	}

    public static class TestCases{
    	public int N;
    	public int K;
    	public int[] arr;
    	public int getMinimumCost() {
    		int min=0;
    		Arrays.sort(arr);
    		for(int i=0;i<N;i++) {
    			min=Math.min(min, getCost(i));
    		}
    		return min;
    	}
    	public int getCost(int index) {
    		int cost=0;
    		int de = 0;
    		for(int i=0;i<N;i++) {
    			if (de==K) {
    				break;
    			}
    			if (i==index) {
    				continue;
    			}
    			if (arr[i] == arr[index]) {
    				de++;
    			} else 
    			if (arr[i] < arr[index]) {
    				
    			}
    		}
    		return cost;
    	}
    }
}
