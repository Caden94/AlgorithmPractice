package algorithmsAndDataStructures.linear;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        // @Test
        System.out.println("Test 1: 2 == " + calculate("1 + 1"));
        // @Test
        System.out.println("Test 2: 3 == " + calculate("4 - 1"));
        // @Test
        System.out.println("Test 3: 8 == " + calculate("4 * 2"));
        // @Test
        System.out.println("Test 4: 2 == " + calculate("4 / 2"));
        // @Test
        System.out.println("Test 5: 16 == " + calculate("4 ^ 2"));
        // @Test
        System.out.println("Test 6: 7 == " + calculate("(1+(4+2)"));
        // @Test
        System.out.println("Test 7: 6 == " + calculate("1 * 2 * 3"));
        // @Test
        System.out.println("Test 8: 2 == " + calculate("1 * 6 / 3"));
        // @Test
        System.out.println("Test 9: 2 == " + calculate("12 / (3 + 3)"));
        // @Test
        System.out.println("Test: 2 == " + calculate("12 / ((11 - 3 * 2) + 1)"));

    }
    // 12 / ((11 - 3 * 2) + 1)
    // nums: 12 5 1
    // ops: / ( +
    public static int calculate(String s) {
        char[] input = s.replaceAll("\\s", "").toCharArray();
        // operation stack
        Deque<Character> ops = new ArrayDeque<>();
        // numbers stack
        Deque<Integer> nums = new ArrayDeque<>();
        // priority map
        Map<Character, Integer> map = new HashMap<>();
        // set sign priority
        map.put('+', 1); map.put('-', 1); map.put('*', 2); map.put('/',2); map.put('^', 3); map.put('(', -1); map.put(')', 0);

        // calculate
        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i])) { // num
                int num = 0;
                while (i < input.length && Character.isDigit(input[i])) {
                    num = num * 10 + input[i++] - '0';
                }
                nums.push(num);
            }
            if (i >= input.length) { break; } // out of boundary
            // operations
            if (input[i] == '+' || input[i] == '-' || input[i] == '*' || input[i] == '/' || input[i] == '^') {
                if (ops.isEmpty() || map.get(ops.peek()) <= map.get(input[i])) {
                    ops.push(input[i]);
                } else {
                    while (!ops.isEmpty() && map.get(input[i]) < map.get(ops.peek())) {
                        calculate_help(nums, ops.pop()); // curr_priority < prev_priority2: cal
                    }
                    ops.push(input[i]);
                }
            } else if (input[i] == '(') { // '('
                ops.push(input[i]);
            } else { // ')'
                while (!ops.isEmpty() && map.get(input[i]) < map.get(ops.peek())) {
                    calculate_help(nums, ops.pop());
                }
                // '('
                if (!ops.isEmpty() && ops.peek() == '(') { // ')'
                    ops.pop();
                }
            }
        }
        while (!ops.isEmpty()) {
            calculate_help(nums, ops.pop());
        }

        // output
        int res = 0;
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }

    private static void calculate_help(Deque<Integer> nums, char op) {
        if (op == '(') { return; } // (1 + ( 2 + 3))
        int right = nums.pop(), left = nums.pop();
        switch (op) {
            case '+':
                nums.push(left + right);
                break;
            case '-':
                nums.push(left - right);
                break;
            case '*':
                nums.push(left * right);
                break;
            case '/':
                nums.push(left / right);
                break;
            case '^':
                nums.push((int)Math.pow(left, right));
                break;
            default:
                break;
        }
    }
}
