import java.util.*;

public class MissingElement {

	public static int n = 13;
	public static int m = 4;
	public static int [] arr = {1,2,3,4,6,8,9,10,11};
	
	public static void main(String[] args) {
		System.out.println("Array = " + Arrays.toString(arr));		
		System.out.println("Missing elements = " 
				+ Arrays.toString(missingElements()));
	}

	public static int[] missingElements() {
		int [] result = new int[m];
		
		int val = 1, j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > val) {
				result[j++] = val;
				val = arr[i]; 
			}
			val++;
		}
		
		if (j < m) {
			while( j < m) {
				result[j] = val++;
				j++;
			}
		}
		return result;
	}
}
