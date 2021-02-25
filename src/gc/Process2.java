package gc;


public class Process2 extends Process1 {
    Process2(){

        System.out.println("Process2 init");
    }

    public static void main(String[] args){
        new Process2();
        new Process2();
    }
}
