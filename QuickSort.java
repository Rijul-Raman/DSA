public class QuickSort {
    static void quickSort (int[] arr, int low, int high) {
        if (low<high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static int partition (int[] arr, int low, int high) {
        int i = low, j = low;
        int pivot = arr[high];
        while (i<=high) {
            if (arr[i]<=pivot) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j-1;
    }

    static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9, -3, 6, 8, 2, 5, -1, 0, 3};
        quickSort(nums, 0, nums.length-1);
        for(int i = 0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}