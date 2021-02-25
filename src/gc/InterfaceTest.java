package gc;

public interface InterfaceTest {
    int i = 98;
     public abstract void fun();
     default void fun1(){
         fun();
     }
}
