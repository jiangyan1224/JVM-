package gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class BTraceTest {
    public int add(int a, int b){
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        BTraceTest test = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = ThreadLocalRandom.current().nextInt();
            int b = ThreadLocalRandom.current().nextInt();
            System.out.println(test.add(a, b));
        }
    }
}
