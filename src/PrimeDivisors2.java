/**
 * Created by prathamesh on 7/2/17.
 */
public class PrimeDivisors2 {
    /**
     * The prime factors of 13195 are 5, 7, 13 and 29.

        What is the largest prime factor of the number 600851475143 ?
     */

    public static void main(String [] args) {
        long num = 600851475143L;
        long temp = num;
        long topPrime = 0;
        boolean [] primes = new boolean[2000];
        for (int i = 2; i<primes.length; i++) {
            primes[i] = true;
        }
        for (int i = 2; i<primes.length; i++) {
            if (primes[i]) {
                for (int j=i; i*j < primes.length; j++) {
                    primes[i*j] = false;
                }
            }
        }
        for (long i=2; i < temp/2; i++) {
            Long index = i;
            if (temp % i == 0L && primes[index.intValue()]) {
                topPrime = i;
                temp /= i;
            }
        }
        System.out.println(topPrime);
    }
}
