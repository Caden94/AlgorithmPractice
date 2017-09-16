package designPatterns;

/**
 * Created by lujianyu on 7/27/17.
 */
public class Enumerate {
    public enum Day {
        SUNDAY(7), MONDAY(1), TUESDAY(2), WEDNESDAY(3),
        THURSDAY(4), FRIDAY(5), SATURDAY(6);

        private final int val;

        Day(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }
    }

    public static void main(String[] args) {
        System.out.println(Day.valueOf("SUNDAY").getVal());
    }
}
