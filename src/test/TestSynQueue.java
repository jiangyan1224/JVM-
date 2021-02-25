package test;

import gc.TestClass;
import synQueue.ArrayBlocking;

import java.util.concurrent.ArrayBlockingQueue;

public class TestSynQueue {
    public static void main(String[] args){

        System.out.println(TestClass.mmm);


        ArrayBlocking sq = new ArrayBlocking(10);
        int num = 1;
            new Thread(() -> {
            for(int i = 0; i < 9; i++) {
                sq.push(i);
            }
        }).start();
            new Thread(() -> {
            for(int i = 0; i < 9; i++) {
                sq.pop();
            }
        }).start();
    }
}
