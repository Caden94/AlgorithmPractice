package algorithmsAndDataStructures.linear;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Test 1: 2 = " + calculate("1 + 1"));
        System.out.println("Test 2: 4 = " + calculate(" 6-4 / 2 "));
        System.out.println("Test 3: 21 = " + calculate("2*(5+5*2)/3+(6/2+8)"));
        System.out.println("Test 4: -12 = " + calculate( "(2+6* 3+5- (3*14/7+2)*5)+3"));

        System.out.println("Test 5: -8 = " + calculate("(5) - (6) - (7)"));
    }
    public static int calculate(String s) {
        char[] expr = s.toCharArray();
        Map<Character, Integer> map = generateOpPriorityMap();

        Deque<Integer> nums = new ArrayDeque<>(); // number stack
        Deque<Character> ops = new ArrayDeque<>(); // operation stack

        for (int i = 0; i < expr.length; i++) {
            char c = expr[i];
            if (Character.isDigit(c)) { //  nums
                int num = 0;
                while (i < expr.length && Character.isDigit(expr[i])) {
                    num = num * 10 + (expr[i++] - '0');
                }
                i--;
                nums.push(num);
            } else if (c == ' ') {
                continue;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    cal(nums, ops);
                }
                ops.pop(); // remove '('
            } else { // + - * /
                while (!ops.isEmpty() && map.get(c) < map.get(ops.peek())) {
                    cal(nums, ops);
                }
                ops.push(c);
            }
        }
        // final computation
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.peek();
    }

    private static void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (ops.peek() == '-') {
            int temp = 0;
            while (!ops.isEmpty() && ops.peek() == '-') {
                temp -= nums.pop();
                ops.pop();
            }
            nums.push(nums.pop() + temp);
        } else {
            int num2 = nums.pop();
            int num1 = nums.pop();
            nums.push(cal(num1, num2, ops.pop()));
        }

    }

    private static int cal(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else {
            return num1 / num2; // assume num2 != 0
        }
    }

    private static Map<Character, Integer> generateOpPriorityMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put('+', 0);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        return map;
    }
}
