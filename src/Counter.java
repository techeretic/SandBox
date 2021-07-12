import java.util.Arrays;


public class Counter {
	
	private static int [] arr = {4,4,4,4,5,6,6,6,6,6,7,7,7,9,9,9,11,11,12};
	
	private static int counter = 0;

	public static void main(String[] args) {

		System.out.println("Array is : " + Arrays.toString(arr));

		System.out.println("Count is : " + Arrays.toString(count(arr)));

//		int counter = 1, prev=arr[0];
//		for (int i=1;i<arr.length;i++) {
//			if (prev != arr[i]) {
//				if (i == arr.length-1) {
//					if (prev == arr[i]) {
//						counter++;
//					} else {
//						System.out.println("Count of " + arr[i] + " = " + 1);
//					}
//				}
//				System.out.println("Count of " + prev + " = " + counter);
//				counter = 1;
//				prev = arr[i];
//			} else {
//				counter++;
//			}
//		}
	}
	
	//return: index age, value count of this age
	public static int[] count(int[] input) {
		int[] count = new int[input[input.length-1]+1];
		count (input, 0, input.length-1, count);
		return count;
	}
		
	private static void count(int[] input, int begin, int end, int[] count) {
		counter++;
		System.out.println("Counter = " + counter + " -> Begin at : " + begin + "(" + arr[begin]
				+ ") Middle at : " + (begin+end)/2 + "(" + arr[(begin+end)/2]
				+ ") End at : " + end + "(" + arr[end] + ")");
		if (input[begin] == input[end]) {
			count[input[begin]] += end-begin+1;
		}
		else {
			count(input, begin, (begin+end)/2, count);
			count(input, (begin+end)/2 + 1, end, count);
		}		
	}
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();

		for (char b : s.toCharArray()) {
			if (b == '(' || b == ')') {
				sb.append(b);
			}
		}

		if (sb.length() == 0) {
			return s;
		}

		return "";
	}
}
