package algorithmsAndDataStructures.linear;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        System.out.println("sample");
        for (int i : nums) {  System.out.print(i + " "); }
        System.out.println();
        // test 1
        System.out.println("test1");
        int[] t1 = circularlyRightShift(nums);
        for (int i : t1) {  System.out.print(i + " "); }
        System.out.println();
    }

    private static int[] circularlyRightShift(int[] nums) {
        int[] res = nums.clone();
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            swap(res, i, i - 1);
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            // a ^ a = 0
            // a ^ 0 = a
            nums[i] ^= nums[j]; // i = i ^ j
            nums[j] ^= nums[i]; // j = i ^ j ^ j = i
            nums[i] ^= nums[j]; // i = i ^ j ^ i = j
        }
    }
}
