package oop;

/**
 * Created by lujianyu on 7/11/17.
 *
 * Generic
 * T -> Type
 * E -> Element
 * K -> Key
 * V -> Value
 */
public class Box <T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private static class Pair <K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static <K, V> boolean compare(Pair pair1, Pair pair2) {
        return pair1.getKey().equals(pair2.getKey())
                && pair1.getValue().equals(pair2.getValue());
    }

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setT("Box");
        System.out.println(box.getT());

        Pair<String, Integer> pair1 = new Pair<>("pair1", 1);
        Pair<String, Integer> pair2 = new Pair<>("pair2", 2);
        System.out.println(compare(pair1, pair2));

    }
}
