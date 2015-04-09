import java.util.*;

public class ZeroShift {

	private static int count = 0;
	private static int [] arr = {0,0,0,0,3,4,5,4,6,0,0,5,6,5,0,0,4,5,6,90,0,0,5,6,0};
	
	public static void main(String[] args) {
		System.out.println("Array Length = " + arr.length);
		System.out.println("Before \t\t-> " + Arrays.toString(arr));
		moveZerosToRight();
		System.out.println("After \t\t-> " + Arrays.toString(arr));
		System.out.println("Hops -> " + count);
	}

	private static void moveZerosToRight() {
		int temp;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;j<arr.length;j++) {
				count++;
				if (arr[i]==0 && arr[j] != 0) {
					System.out.println("During HOP " + count + " -> " + Arrays.toString(arr));
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}
