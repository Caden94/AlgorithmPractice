package errorHandling;

/**
 * Created by lujianyu on 7/29/17.
 */
public class ErroHandling {
    public int count = 2;
    public void minus() throws Exception {
        if (count == 0) {
            throw new Exception("IS EMPTY");
        }
        count--;
    }

    public static void main(String[] args) {
        ErroHandling erroHandling =  new ErroHandling();
        while (true) {
            try {
                erroHandling.minus();
                System.out.println(erroHandling.count);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
