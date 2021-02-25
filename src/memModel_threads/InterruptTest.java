package memModel_threads;

public class InterruptTest {
    private static final Object obj = new Object();
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            synchronized (obj){
                while (true){
                    System.out.println("busying");
                }
            }
        }
    }
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println("sleeping");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread busyThread = new Thread(new BusyRunner(), "busy");
//        Thread sleepThread = new Thread(new SleepRunner(), "sleep");
//        busyThread.setDaemon(true);
//        sleepThread.setDaemon(true);
        busyThread.start();
//        sleepThread.start();
        Thread.currentThread().sleep(1000);
        busyThread.interrupt();
//        sleepThread.interrupt();
        System.out.println("----------------");
        System.out.println("busy "+busyThread.isInterrupted());
//        System.out.println("sleep "+sleepThread.isInterrupted());
//        Thread.currentThread().sleep(3000);
    }
}
