import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TeamPerformace2 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] sizes = br.readLine().split(" ");
        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);
        char[][] teams = new char[N][M];
        for(int i=0;i<N;i++) {
        	teams[i] = br.readLine().toCharArray();
        }
        long startTime = System.currentTimeMillis();
        int teamCount = 0, max = 0, result = 0;
        for (int i=0;i<N-1;i++) {
        	for(int j=i+1;j<N;j++) {
        		result = getSubjects(teams[i], teams[j]);
        		if (result == max && result != 0) {
        			teamCount++;
        		} else if (max < result) {
        			max = result;
        			teamCount = 1;
        		}
        	}
        }
        System.out.println(String.valueOf(max) + "\n" + teamCount);
        System.out.println("\nTime Taken : " + (System.currentTimeMillis()-startTime) + "s");
        br.close();
	}
	
	private static int getSubjects(char[] t1, char[] t2) {
		int sum = 0;
		for(int i=0;i<t1.length;i++) {
			sum += (t1[i] == '1' || t2[i] == '1') ? 1 : 0;
		}
		return sum;
	}
}
