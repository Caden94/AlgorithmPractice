package algorithmsAndDataStructures.linear;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public static void main(String[] args) {
        // @Test == 2
        System.out.println(calculate("1 + 1"));
        // @Test == 3
        System.out.println(calculate("4 - 1"));
        // @Test == 23
        // System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        // @Test == 10
        System.out.println(calculate2("2 ^ 3 + 2"));
    }

    public static int calculate(String s) {
        int res = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                int num = 0;
                while (i < ss.length && Character.isDigit(ss[i])) {
                    num = num * 10 + ss[i++] - '0';
                }
                res += num * sign;
            }
            if (i >= ss.length) { break; }
            if (ss[i] == ' ') { continue; }
            if (ss[i] == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (ss[i] == '+') {
                sign = 1;
            } else if (ss[i] == '-') {
                sign = -1;
            } else {
                res = res * stack.pop() + stack.pop();
            }
        }
        if (!stack.isEmpty()) { res = stack.pop(); }
        return res;
    }

    public static int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] ss = s.replaceAll("\\s", "").toCharArray();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                num = 0;
                while (i < ss.length && Character.isDigit(ss[i])) {
                    num = num * 10 + ss[i++] - '0';
                }
            }
            if (sign == '+') {
                stack.push(num);
            } else if (sign == '-') {
                stack.push(-num);
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
            } else if (sign == '/') {
                stack.push(stack.pop() / num);
            } else {
                stack.push((int)Math.pow(stack.pop(), num));
            }
            if (i < ss.length) {
                sign = ss[i];
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
