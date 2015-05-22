import java.util.*;


public class PrimeDivisors {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
    	int size = N/2;
        boolean[] isPrime = new boolean[size+1];
        for(int i=2;i<size;i++){
            isPrime[i] = true;
        }
        for (int i = 2; i*i <= size; i++) {
            if (isPrime[i]) {
                for (int j = i; i*j <= size; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        if (checkIsSmith(N, isPrime)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        reader.close();
    }
    
    private static boolean checkIsSmith(int N, boolean[] isPrime) {
        boolean result = false;
        List<Integer> primeDivisors = getPrimeDivisers(N, isPrime);
        int primeSum = 0;
        int sum = getSumOfDigits(N);
        for(int n : primeDivisors) {
            primeSum += getSumOfDigits(n);
        }
        if (sum == primeSum) {
            result = true;
        }
        return result;
    }
    
    private static List<Integer> getPrimeDivisers(int N, boolean[] isPrime) {
        List<Integer> result = new LinkedList<Integer>();
        int div = 2;
        while(div <= N) {
            if (N%div == 0 && isPrime[div]) {
                result.add(div);
                N=N/div;
                System.out.println("N = " + N + " | div = " + div);
            } else {
                div++;
            }
        }
        return result;
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
