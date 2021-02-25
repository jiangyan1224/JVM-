package threadSafe;

public class ThreadLocalTest {
    private final int value = func();
    public static int val = 12;

    {
        System.out.println("实例代码块");
    }
    public ThreadLocalTest(){
        System.out.println("constror"+value);
    }
    private int func() {
        System.out.println("func" + value);
        return 123;
    }
    public int getValue(){
        return value;
    }

    public static void main(String[] args){
        System.out.println(new ThreadLocalTest().getValue());
        System.out.println(ThreadLocalTest.val);
    }
}
