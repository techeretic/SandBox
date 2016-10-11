import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class TopN {

	public static void main(String[] args) {
		int [] arr = {2,1,20,45,23,5,6,4,2,4,12,65,8,5,19};
		int K = 5;

		System.out.println("Array is : " + Arrays.toString(arr));
		System.out.println("Top " + K + " Values are : " + Arrays.toString(FindTopK(arr, K)));
	}

	public static int[] FindTopK(int[] arr, int k)
    {
        int[] newlist = new int[k];
        if (arr.length < k)
        {
            System.out.println("Given array has fewer elements than K value, hence returning all 0s");
            return newlist;
        }
        else if (arr.length == k)
        {
            for (int i = 0; i < k; i++)
            {
                newlist[i] = arr[i];
            }
            return newlist;
        }
        else
        {
            TreeSet<Integer> topK = new TreeSet<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
            
            for (int i = 0; i<arr.length; i++) topK.add(arr[i]);
            
            System.out.println("Size of Tree = " + topK.size() + " and K = " + k);
            int j=0;
            for (Integer in : topK) {
            	newlist[j++] = in;
            	if (j >= k) break;
            }
            return newlist;
        }
    }
}
