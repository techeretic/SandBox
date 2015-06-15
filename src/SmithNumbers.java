import java.util.*;

public class SmithNumbers {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        if (getSumOfDigits(N) == getSumOfDivisors(N)) {
        	System.out.println(1);
        } else {
        	System.out.println(0);
        }
        reader.close();
    }
    
    private static int getSumOfDivisors(int N) {
    	int total = 0;
    	for(int i=2;i<=N;i++) {
    		while(N%i == 0) {
    			total+=getSumOfDigits(i);
        		N /= i;
    		}
    	}
    	return total;
    }

    private static int getSumOfDigits(int N) {
    	int sum = 0;
        String num = String.valueOf(N);
        for(char ch : num.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(ch));
        }
        return sum;
    }
}
