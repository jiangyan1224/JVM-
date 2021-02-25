package threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

public class Incre_get_incre {
    public static void main(String[] args){
        AtomicInteger first = new AtomicInteger(5);
        int a = first.getAndIncrement();
        System.out.println("a value:"+a);//5
        System.out.println("first value:"+first);//6

        AtomicInteger second = new AtomicInteger(5);
        int b = second.incrementAndGet();
        System.out.println("b value:"+b);//6
        System.out.println("seconde value:"+second);//6

    }
}
