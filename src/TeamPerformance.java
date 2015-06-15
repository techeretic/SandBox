import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TeamPerformance {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] sizes = br.readLine().split(" ");
        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);
        char[][] teams = new char[N][M];
        for(int i=0;i<N;i++) {
        	teams[i] = br.readLine().toCharArray();
        }
        int teamCount = 0, max = 0, result = 0;
        for (int i=0;i<N-1;i++) {
        	for(int j=1;j<N;j++) {
        		result = getVal(teams[i])|getVal(teams[j]);
        		if (result == max && result != 0) {
        			teamCount++;
        		} else if (max < result) {
        			max = result;
        			teamCount = 1;
        		}
        		System.out.println("Teams = " + teamCount + " MAX = " + max + " other RESULT = " + result);
        	}
        }
        System.out.println(getMaxFromString(max) + "\n" + teamCount);
        br.close();
	}

	private static int getVal(char[] val) {
		return Integer.parseInt(String.valueOf(val), 2);
	}
	
	private static int getMaxFromString(int val) {
		String result = Integer.toBinaryString(val);
		return result.length() - result.replace("1","").length();
	}
}
