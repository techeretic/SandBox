import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;


public class GameOfOz {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        TestCases [] t_arr = new TestCases[T];
	    for(int i=0;i<T;i++) {
	    	t_arr[i] = new TestCases();
	        line = br.readLine();
	        t_arr[i].N = Integer.parseInt(line);
	        line = br.readLine();
	        String[] parsed = line.split(" ");
	        t_arr[i].arr = new HashSet<Integer>();
	        for(int j=0;j<t_arr[i].N;j++) {
	        	t_arr[i].arr.add(Integer.parseInt(parsed[j]));
	        }
	        System.out.println(t_arr[i].getMaxTries());
	    }
    }
    
    public static class TestCases{
    	public int N;
		HashSet<Integer> arr;
    	public int getMaxTries() {
    		int max = 0;
    		Integer[] temp = new Integer[N];
    		arr.toArray(temp);
    		for(int i=0;i<N;i++){
    			max = Math.max(max, getMax(temp[i]));
    		}
    		return max;
    	}
        public int getMax(int val) {
        	HashSet<Integer> temp = arr;
        	int count = 0;
    		Integer[] iArr = new Integer[temp.size()];
    		temp.toArray(iArr);
    		for(int i : iArr) {
    			if (temp.contains(i)) {
    				temp.remove(i);
    				if (temp.contains(i+1)) {
    					temp.remove(i+1);
    				}
    				if (temp.contains(i-1)) {
    					temp.remove(i-1);
    				}
    				count++;
    			}
    			
    		}
        	return count;
        }
    }
    
}
