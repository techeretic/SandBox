/**
 * Created by pshetye on 10/13/16.
 */
public class LengthOfLis {
    public static int lengthOfLIS(int[] nums) {
        int bestMax = 0;
        int localMax;
        int lastMax;
        for (int i = 1; i< nums.length - 1 ; i++) {
            localMax = 0;
            lastMax = -9999;
            for (int j = i; j < nums.length; j++) {
                if (lastMax < nums[j]) {
                    localMax++;
                    lastMax = nums[j];
                }
            }
            if (localMax > bestMax) {
                bestMax = localMax;
            }
        }
        return bestMax == 1? 0 : bestMax;
    }

    public static void main(String [] args) {
        int[] ip = {10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(ip));
    }
}
