package memModel_threads;

public class VolatileTest {
    public static volatile int race = 0;
    public static void increase(){
        race++;
    }
    public static final int THREADS_COUNT = 20;
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i =0; i < THREADS_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();//这个race++操作就算只有一条字节码指令完成，也不能说明这个操作具有【原子性】
                    }
                }
            });
            threads[i].start();
        }
//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i].join();
        }
        System.out.println(race);
    }
}
