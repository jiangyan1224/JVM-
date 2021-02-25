package synQueue;

/**
 * 自己实现一个线程安全的队列
 * 实现方法：使用数组实现一个循环队列，left right分别指向第一个元素和最后一个元素后一个位置
 * push和pop时需要对整个实例加锁
 * */
public class ArrayBlocking {
    private int[] elements;
    private Integer left, right;
    private int size, length;
    public ArrayBlocking(int length){
        elements = new int[length];
        this.size = 0;
        this.length = length;
        left = 0;//left出
        right = 0;//right入
    }
    public void push(int x){
        synchronized(this) {
            while((right - left + length) % length >= length - 1) {
                try {
                    System.out.println("队列已满");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            elements[right] = x;
            right  = (right + 1) % length;
            System.out.println("push完"+x+"当前容量为："+left+","+right+","+ ( right - left + length) % length);
            this.notify();//唤醒可能正因为队列为空而等待的消费者
        }
    }
    public int pop() {
        synchronized(this) {
            while(right == left) {
                try {
                    System.out.println(left +","+right+"队列已空");
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            int pop =  elements[left];
            left = (left + 1) % length;
            System.out.println("pop完"+pop+"，当前容量为："+left+","+right+","+ (right - left + length) % length);
            this.notify();
            return pop;
        }
    }
}
