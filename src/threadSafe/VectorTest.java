package threadSafe;

import lombok.SneakyThrows;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Vector;

public class VectorTest {
    private static Vector<Integer> vector = new Vector<>();
    public static void removeLast(){
        int lastIndex = vector.size() -1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vector.remove(lastIndex);
    }
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            vector.add(i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    removeLast();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    removeLast();
                }
            }
        }).start();
    }
}
