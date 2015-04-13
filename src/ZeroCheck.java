import java.util.*;

public class ZeroCheck {
	
	public static int [] arr = {10,2,1,3,-5,-6};

	public static void main(String[] args) {
		System.out.println("Array is : " + Arrays.toString(arr));
		System.out.println("IS Zero Possible : " + isZeroPossible());
	}

	public static boolean isZeroPossible() {
		HashSet<Integer> mArr = new HashSet<>();
		for(int val : arr) {
			mArr.add(val);
		}
		Arrays.sort(arr);
		System.out.println("Array is : " + Arrays.toString(arr));
		int i=0, j=arr.length-1, diff = 0;
		while(i < arr.length-1) {
			diff = 0-(arr[i]+arr[j]);
			System.out.println("arr[i] = " + arr[i] + " arr[j] = " + arr[j] + " Diff = " + diff);
			if (mArr.contains(diff)) {
				return true;
			} else {
				if (j == i+1) {
					i++; j = arr.length-1; 
				} else {
					j--;
				}
			}
		}
		return false;
	}
}
