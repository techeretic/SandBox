import java.util.*;

public class TargetSumPermutation {

	private static HashSet<String> result = new HashSet<String>();
	private static int [] inputArray = {2, 3, 5};
	private static int target = 15;
	
	public static void main(String[] args) {
		System.out.println("InputArray = " + Arrays.toString(inputArray));
		System.out.println("Target = " + target);
		for(int i=0; i<inputArray.length; i++) {
			checkSum("",i,0);
		}
		for(String res : result) {
			System.out.println(res);
		}
	}

	private static void checkSum(String sofar, int next, int sum) {
		if (next >= inputArray.length) return;
		if (sum==target) {
			result.add(sofar);
			return;
		}
		
		if (sum > target) {
			return;
		}
		checkSum(sofar+Integer.toString(inputArray[next]), next, sum+inputArray[next]);
		checkSum(sofar+Integer.toString(inputArray[next]), next+1, sum+inputArray[next]);
	}
}
