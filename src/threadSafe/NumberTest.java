package threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberTest {
    static AtomicInteger a = new AtomicInteger(0);
//    static FakeAtomicInteger fa = new FakeAtomicInteger(0);
    static Thread[] threads = new Thread[20];
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run(){
                    for (int j = 0; j < 1000; j++) {
                        a.incrementAndGet();
//                        a.getAndIncrement();
//                        fa.getAndIncrement();
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
        System.out.println(a);
//        System.out.println(fa);
    }

}
