package gc;

public class FieldResolution {
    interface Interface0{
        int a = 5;
    }
    interface Interface1 extends Interface0{
        int a = 7;
    }
    interface Interface2{
        int a = 6;
    }
    static class Parent implements Interface1{
        public static int a = 8;
    }
    static class Sub implements Interface2{
        public static int a = 9;
    }
    public static void main(String[] args){
        System.out.println(Sub.a);
    }
}
