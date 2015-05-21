import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TestClass {
	public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        String [] parsed = line.split(" ");
        validateInput(parsed, N);
        int [] dom = new int [N];
        for(int i=0;i<N;i++) {
        	dom[i]=Integer.parseInt(parsed[i]);
        }
        //System.out.print("\nEnter Brian's speeds at said checkpoints (Separated by space) : ");
        line = br.readLine();
        parsed = line.split(" ");
        validateInput(parsed, N);
        int [] brian = new int [N];
        for(int i=0;i<N;i++) {
        	brian[i]=Integer.parseInt(parsed[i]);
        }
        int highB=0,highD=0, prevB=brian[0], prevD=dom[0];
        for(int i=1;i<N;i++) {
        	highB = Math.max(highB, Math.abs(prevB-brian[i]));
        	prevB = brian[i];
        	highD = Math.max(highD, Math.abs(prevD-dom[i]));
        	prevD = dom[i];
        }
        if (highB > highD) {
        	System.out.println("\nBrian " + highB);
        } else {
        	System.out.println("\nDom " + highD);
        }
    }
	
	private static void validateInput(String [] ip, int N) {
        if (ip.length != N) {
        	System.out.println("Incorrect Input!! Should've been " + N + " entries");
        	System.exit(0);
        }
	}
}
