package memModel_threads;

public class JoinDemo extends Thread{
    int i;
    Thread previousThread; //上一个线程 main
    public JoinDemo(Thread previousThread,int i){
        this.previousThread=previousThread;
        this.i=i;
        this.setName("join"+i);
    }
    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();//main.join()  join1获取到main线程的锁，只要main.isAlive, this->main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:"+i);
    }
    public static void main(String[] args) {
        Thread previousThread=Thread.currentThread();
        for(int i=0;i<10;i++){
            JoinDemo joinDemo=new JoinDemo(previousThread,i);
            joinDemo.start();
            previousThread=joinDemo;
        }
    }
}

