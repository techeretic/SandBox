import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PiSong {
	private static final String sPI = "31415926535897932384626433833";
	private static final String sIsPi = "It's a pi song.";
	private static final String sIsNotPi = "It's not a pi song.";
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] ip = new String[N];
        int i=0;
        while(i < N) {
        	ip[i] = br.readLine();
        	i++;
        }
        
        for(String s : ip) {
        	System.out.println(isPiSong(s));
        }
        br.close();
    }
    
    private static String isPiSong(String ip) {
    	String [] words = ip.split(" ");
    	StringBuffer buff = new StringBuffer();
    	for(String s : words) {
    		buff.append(s.length());
    	}
    	if (sPI.substring(0, buff.length()).equals(buff.toString())) {
    		return sIsPi;
    	} else {
    		return sIsNotPi;
    	}
    }
}
