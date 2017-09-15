package algorithmsAndDataStructures.linear;

import java.util.Random;

public class ReservoirSampling {
    int[] nums;
    Random rand;

    public static void main(String[] args) {
        ReservoirSampling reservoirSampling = new ReservoirSampling(new int[] {1, 1, 2, 3, 1});

        System.out.println(reservoirSampling.pick(1));
        System.out.println(reservoirSampling.pick(1));
        System.out.println(reservoirSampling.pick(1));
        System.out.println(reservoirSampling.pick(1));
        System.out.println(reservoirSampling.pick(1));
    }

    public ReservoirSampling(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    /*
        target: eventually each element has 1 / n possibility to be chosen
        solution: randomly select an int from 0 to n.
                  If x equals 0, set the res as the current index.
        explain: The probability is always 1 / n for the latest appeared number.
        example:
            n = 1, 1th 1/n = 1
            n = 2, 1th 1/1 * 1/2 = 1/2, 2th 1/2
            n = 3. 1th 1/2 * 1/2 * 2/3 = 1/3, 2th 1/2 (to be chosen) * 2/3 (to be kept) = 1/3, 3th 1/3
            ...
            n = n, ith 1 / n

     */
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int x = rand.nextInt(++total);
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}
