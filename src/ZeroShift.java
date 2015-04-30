import java.util.*;

public class ZeroShift {

	private static int count = 0;
	private static int [] arr = {0,0,0,0,3,4,5,4,6,0,0,5,6,5,0,0,4,5,6,90,0,0,5,6,0};
	
	public static void main(String[] args) {
		System.out.println("Array Length = " + arr.length);
		System.out.println("Before 	   -> " + Arrays.toString(arr));
		zeroShift();
		System.out.println("After 	   -> " + Arrays.toString(arr));
		System.out.println("Hops -> " + count);
	}
	
	private static void zeroShift() {
		int j=0, n=arr.length-1;
		while(j<=n) {
			count++;
			System.out.println("During	   -> " + Arrays.toString(arr));
			if (arr[j]==0) {
				swap(j,n);
				n--;
			} else {
				j++;
			}
		}
	}
	
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void moveZerosToRight() {
		int temp;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
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

	private static void selectionSort() {
		System.out.println("Selection Sort");
		
		int minIndex = 0, j;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			j = i + 1;
			for (j = i + 1; j < arr.length; j++) {
				count++;
				if (arr[minIndex] == 0 && arr[minIndex] < arr[j]) {
					minIndex = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;

			System.out.println("During HOP " + count + " -> " + Arrays.toString(arr));
		}
	}
	public static void mergeSort(int [] a, int st, int end) {
		count++;
		if (st < end) {
			int mid = (st+end)/2;
			System.out.println("------------st = " + st + " mid = " + mid + " end = " + end);
			mergeSort(a, st, mid);
			mergeSort(a, (mid+1), end);
			merge(a,st,mid,end);
		}
	}
	
	public static void merge(int [] a, int st, int mid, int end) {
		int [] start = new int[mid-st+1];
		int [] ends = new int[end-mid];
		int j=0,k=0;
		for(int i = st; i<=end; i++) {
			if(i<=mid) {
				start[j++] = a[i];
			} else {
				ends[k++] = a[i];
			}
		}
		j=k=0;
		int i=st;
		while(j<start.length && k<ends.length) {
			if (ends[k] == 0 && start[j] > ends[k]) {
				a[i]=start[j];
				start[j]=-1;
				j++;i++;
			} else {
				a[i]=ends[k];
				ends[k]=-1;
				k++;i++;
			}
		}
		
		j=k=0;
		while(j<start.length) {
			if (start[j] != -1) {
				a[i]=start[j];
				i++;
			}
			j++;
		}
		while(k<ends.length) {
			if (ends[k] != -1) {
				a[i]=ends[k];
				i++;
			}
			k++;
		}
	}
}
