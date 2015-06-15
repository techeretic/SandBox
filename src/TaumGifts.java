import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TaumGifts {

	public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String [] sizes = br.readLine().split(" ");
            long B = Integer.parseInt(sizes[0]);
            long W = Integer.parseInt(sizes[1]);
            sizes = br.readLine().split(" ");
            long X = Integer.parseInt(sizes[0]);
            long Y = Integer.parseInt(sizes[1]);
            long Z = Integer.parseInt(sizes[2]);
            
            Y = (X+Z < Y) ? X+Z : Y;
            X = (Y+Z < X) ? Y+Z : X;
            
            sb.append(((B*X)+(W*Y)));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
	}

}
