package algorithmsAndDataStructures.linear;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[]{1,2,2,2,4};
        System.out.println(bs.higher(nums, 2)); // return 3
        System.out.println(bs.higher(nums, 3)); // return 4
        System.out.println(bs.higher(nums, 5)); // return 5

        nums = new int[]{9,10,100,101,1002,10203};
        System.out.println(bs.higher(nums, 10203));
    }

    // lower bound / the floor is the greatest element smaller than or equal to x.
    // target exists, the first element equals to the target
    // target not exists, the last largest element smaller than the target
    public int lower(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        // 1 2 2 3
        // 0 1 2 3
        // i j
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }


    //upper bound / ceiling of x is the smallest element in array greater than or equal to x
    // target exists, the last element equals to the target
    // target not exists, the first smallest element bigger than the target
    public int higher(int[] nums, int target) {

        int n = nums.length;
        int start = 0, end = n - 1;
        // 1 2 2 4
        // 0 1 2 3
        //     i j
        while (start < end) {
            int mid = start + (end - start) / 2 + 1; // think when start + 1 == end && nums[start] == target
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        return nums[start] < target ? start + 1 : start;
    }
}
