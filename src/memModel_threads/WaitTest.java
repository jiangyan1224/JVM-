package memModel_threads;

public class WaitTest {
    private static final Object obj = new Object();
    private static final Object obj1 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread test = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
//                        obj1.wait();//运行报错IllegalMonitorStateException
                        System.out.println("Thread 1 enter wait");
                        obj.wait();
//                        Thread.sleep(1000);
                        System.out.println("Thread 1 从wait处离开");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        while(true){}
                    }
                }
            }
        });
        test.start();

//        Thread.currentThread().sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("Thread3 enter syn");
                    obj.notifyAll();
                    System.out.println("Thread3 notify");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread3 finally exit");
                }
            }
        }).start();
    }




}
