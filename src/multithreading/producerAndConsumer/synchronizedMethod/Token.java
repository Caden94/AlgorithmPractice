package multithreading.producerAndConsumer.synchronizedMethod;

/**
 * Created by lujianyu on 7/19/17.
 */
public class Token {
    private int val;
    private String name;

    public Token(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + val;
    }
}
