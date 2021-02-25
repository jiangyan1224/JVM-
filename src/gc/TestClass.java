package gc;

import com.sun.org.apache.bcel.internal.classfile.Synthetic;

public class TestClass {
    private int m;
    public static String mmm = "ddkajklch";
    private static byte numB = 16;
    private int numI = 78;
    public TestClass(){}
    static{
        System.out.println("TestClass init!");
    }
    String str = "good".intern();
    public final static void inc(){
        "String".intern();
//        return m + 1;
    }

    public static void main(String[] args){
//        Process1.InnerClass obj = new Process1().new InnerClass();
//        int val = Process1.InnerClass.innerval;
//        System.out.println(Process1.staticInnerClass.staticinnnerval);
        System.out.println(Process1.str);
    }
}
