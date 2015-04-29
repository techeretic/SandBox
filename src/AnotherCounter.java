import java.util.Arrays;


public class AnotherCounter {
	
	public static int [] arr = {
		1,0,2,1,0,2,1,1,0,
		2,1,2,1,0,0,1,1,1,}; 

	public static void main(String[] args) {

		int [] count = new int[3];
		int i=0,val=0,j=0;
/*
		for (int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		System.out.println("Array is : \n" + Arrays.toString(arr));
		System.out.println("Sample Size : " + arr.length);
		System.out.println("Values are : " + Arrays.toString(count));
		
		int i=0,val=0,j=0;
		while(i<arr.length) {
			if (count[j] == 0) {
				j++;
			}
			arr[i] = j;
			count[j]--;
			i++;
		}
		System.out.println("Sorted Array is : \n" + Arrays.toString(arr));
*/
		System.out.println("Array is : " + Arrays.toString(arr));
		i=0;
		j=0; 
		int n=arr.length-1, counter = 0;
		
		while(j<=n) {
			counter++;
			switch(arr[j]) {
				case 0 :
					swap(i,j);
					i++; j++;
					break;
				case 1:
					j++;
					break;
				case 2:
					swap(j,n);
					n--;
					break;
			}
			System.out.println("At HOP : " + counter + " Array IS : " + Arrays.toString(arr));
		}
		System.out.println("Hops : " + counter);
		System.out.println("Sorted Array is : " + Arrays.toString(arr));
	}

	public static final void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
