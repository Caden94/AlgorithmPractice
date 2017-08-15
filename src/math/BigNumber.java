package math;

public class BigNumber {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int[] res = new int[Math.max(n1.length, n2.length) + 1];
        int i = n1.length - 1, j = n2.length - 1, k = 0;

        /**
         * pre-calculation
         */
        while (k < res.length) {
            int v1 = i >= 0 ? n1[i--] - '0' : 0;
            int v2 = j >= 0 ? n2[j--] - '0' : 0;
            res[k++] = v1 + v2;
        }


        /**
         * post-calculation
         */
        int carry = 0;
        for (int index = 0; index < res.length; index++) {
            int temp = res[index] + carry;
            res[index] = temp % 10;
            carry = temp / 10;
        }

        /**
         * construct result string
         */
        StringBuilder sb = new StringBuilder();
        for (int index = res.length - 1; index >= 0; index--) {
            if (index == res.length - 1 && res[index] == 0) {
                continue; // remove leading zero
            }
            sb.append(res[index]);
        }
        return sb.toString();
    }
}
