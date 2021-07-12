import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    private int [] nums;

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];

        System.out.println("Starting Partitioning : " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));

        System.out.println("leftIndex : " + nums[left] + "(" + left + ")");
        System.out.println("rightIndex : " + nums[right] + "(" + right + ")");
        System.out.println("pivotIndex : " + nums[pivotIndex] + "(" + pivotIndex + ")");

        swap(pivotIndex, right);

        int storeIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(storeIndex, i);
                storeIndex++;
            }
            System.out.println("Partitioning : " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
        }

        swap(storeIndex, right);

        System.out.println("Finished Partitioning : " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
        System.out.println("storeIndex : " + nums[storeIndex] + "(" + storeIndex + ")");
        System.out.println("Current input : " + Arrays.toString(nums));
        return storeIndex;
    }

    private int quickSelect(int leftIndex, int rightIndex, int kSmallest) {
        if (leftIndex == rightIndex) {
            return nums[leftIndex];
        }

        Random random = new Random();

        int pivotIndex = leftIndex + random.nextInt(rightIndex - leftIndex);

        System.out.println();

        pivotIndex = partition(leftIndex, rightIndex, pivotIndex);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(leftIndex, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(pivotIndex + 1, rightIndex, kSmallest);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int len = nums.length;

        return quickSelect(0, len - 1, len - k);
    }

    public static void main(String [] args) {
        QuickSelect quickSelect = new QuickSelect();
        int [] nums = new int[] {3,2,1,1,1,2,2,2,3,3,3,3,5,6,4};
        int k = 2;
        System.out.println("Input array : " + Arrays.toString(nums) + " | k = " + k);
        System.out.println("Kth largest element in input is : " + quickSelect.findKthLargest(nums, k));
    }
}
