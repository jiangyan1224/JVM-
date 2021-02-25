package gc;

public class OverLoadTest {
    public static void sayHello(Object ar1){
        System.out.println("Object");
    }
    public static void sayHello(int ar1){
        System.out.println("int");
    }
    public static void sayHello(long arg1){
        System.out.println("long");
    }
    public static void sayHello(char ar1){
        System.out.println("char");
    }
    public static void sayHello(float ar1){
        System.out.println("float");
    }
    public static void sayHello(Integer ar1){
        System.out.println("Integer");
    }

    public static void main(String[] args){
        sayHello('/');
    }



}
