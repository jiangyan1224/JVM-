package gc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Process1 {
    static {
        System.out.println( "Process1 static");
    }
    static int i;
    static String str = new String("Process1 string");
    private TestClass t;
    static class staticInnerClass {
        private void func(){}
        static int staticinnnerval;
        static {
            System.out.println("InnerClass static");
        }
    }

    class InnerClass{
        static final int innerval = 0;
//        static final Integer ii = 0;
//        static final String s = new String("123");
//        static final Object obj = new Object();
    }


}
