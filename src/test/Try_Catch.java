package test;

public class Try_Catch {
    public static int try_catch(){
        int a = 0;
        try{
            a = 2;
//            return  a;
        }catch (Exception e){
//            return a;
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("try-catch块之后");
        a = 3;
        return a;
    }
    public static int try_no_catch(){
        int a = 0;
        System.out.println(2/a);

        System.out.println("try-catch块之后");
        a = 3;
        return a;
    }
    public static void main(String[] args){
        System.out.println(try_catch());
//        try_no_catch();
    }
}
