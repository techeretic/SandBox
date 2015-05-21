import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class SumDecimal {

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        int D = Integer.parseInt(line);
        String fmt = "#.";
        StringBuffer buff = new StringBuffer();
        for(int i=0;i<D;i++) {
            buff.append("#");
        }
        fmt += buff.toString();
        DecimalFormat df = new DecimalFormat(fmt);
        String result = df.format(Math.sqrt(N));
        System.out.println(result);
	}

}
