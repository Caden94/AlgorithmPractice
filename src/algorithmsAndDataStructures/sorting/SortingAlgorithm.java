package algorithmsAndDataStructures.sorting;

import java.util.*;

/**
 * Created by lujianyu on 4/23/17.
 */
public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 3, 1, 1, 3, 8, 100};
        // @Test
        print(nums);
        // bubbleSort(nums);
        // selectionSort(nums);
        // insertionSort(nums);
        //  mergeSort(nums);
        // quickSort(nums);
        // countingSort(nums);
        // bucketSort(nums);
        // bubbleSort(nums);
        // sortByFrequency(nums);
        print(nums);
    }

    /**
     * Bubble Sort, Time: O(n^2), Space: O(1), Stable: Yes
     */
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // The last i elements are sorted
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // Key Point: Biggest bubble goes right
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            print(nums, i);
        }
    }

    /**
     * Selection Sort, Time: O(n^2), Space: O(1), Stable: Yes
     */
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int small = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[small]) {
                    small = j;
                }
            }
            swap(nums, i, small);
            print(nums, i);
        }
    }

    /*
     * Insertion Sort, Time: O(n^2), Space: O(1), Stable: Yes
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
            print(nums, i);
        }
    }

    /**
     * Merge Sort, Time: O(nlogn), Space: O(n), Stable: Yes
     */

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        // Divide
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        // Conquer
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        // TODO Auto-generated method stub
        // -> use helper array
        // Extra O(n) space used to copy the original array
        int[] left = new int[mid - start + 1], right = new int[end - mid];
        for (int i = 0; i < mid - start + 1; i++) {
            left[i] = nums[start + i];
        }

        for (int j = 0; j < end - mid; j++) {
            right[j] = nums[mid + 1 + j];
        }
        // Merge two sorted array
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[start + k++] = left[i++];
            } else {
                nums[start + k++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[start + k++] = left[i++];
        }

        while (j < right.length) {
            nums[start + k++] = right[j++];
        }
    }

    /**
     * Quick Sort Time: O(nlogn), Space: O(1), Stable: No
     * The key process in quickSort is partition(). Target of
     * partitions is, given an array and an element x of array as pivot, put x
     * at its correct position in sorted array and put all smaller elements
     * (smaller than x) before x, and put all greater elements (greater than x)
     * after x. All this should be done in linear time.
     */
    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        // TODO Auto-generated method stub
        if (start >= end) { return; }
        int pivot = nums[end], pos = start;// find pivot
        // partition
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, pos++, i);
            }
        }
        swap(nums, pos, end);
        quickSort(nums, start, pos - 1);
        quickSort(nums, pos + 1, end);
    }

    /**
     * Counting Sort Time: O(n + k), Space: O(k)
     */
    private static void countingSort(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[index++] = i + min;
                counts[i]--;
            }
        }
    }

    /**
     * Bucket Sort Time:O(n + k) ~ O(n^2), Space: O(k * n)
     */
    private static void bucketSort(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // put into bucket
        int t = nums.length;
        int k = (max - min) / (t - 1);
        List<Integer>[] counts = new List[k]; // k: number of buckets

        for (int num : nums) {
            if (counts[(num - min) / t] == null) { counts[(num - min) / t] = new ArrayList<>(); }
            counts[(num - min) / t].add(num);
        }
        // output
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == null) { continue; }
            List<Integer> temp = counts[i];
            Collections.sort(temp);
            for (int num : temp) {
                nums[index++] = num;
            }
        }
    }

    /**
     *  Sort by Frequency
     */
    private static void sortByFrequency(int[] nums) {
        if (nums == null || nums.length <= 0) { return; }
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1]; // count 1 ~ n
        Map<Integer, Integer> map = new HashMap<>();
        // cal count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // put into bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (bucket[val] == null) { bucket[val] = new ArrayList<>(); }
            bucket[val].add(key);
        }
        // output
        int index = 0;
        for (int i = bucket.length - 1; i > 0; i--) { // :right to left
            if (bucket[i] == null) { continue; }
            for (int num : bucket[i]) { // : elements with count i
                for (int j = 0; j < i; j++) {
                    nums[index++] = num;
                }
            }
        }
    }

    /**
     * Swap
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Print
     */
    private static void print(int[] nums) {
        System.out.print("--- ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    private static void print(int[] nums, int i) {
        System.out.print(i + " : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
