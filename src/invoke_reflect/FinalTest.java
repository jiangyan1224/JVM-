package invoke_reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

public class FinalTest {
    static class Test{
        class GrandFather{
            void thinking(){
                System.out.println("i am grandfather");
            }
        }

        class Father extends GrandFather{
            void thinking(){
                System.out.println("i am father");
            }
        }

        class Son extends Father{
            //https://stackoverflow.com/questions/60322808/i-want-to-print-hi-grandfatherbut-it-seems-to-print-hi-father
            void thinking(){//在这里调用其祖父类的thinking方法
                //0
                super.thinking();// i am father
                MethodType mt = MethodType.methodType(void.class);
                try {
                    //1
                    MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                    mh.invoke(this); // i am father
                    //2
                    mh = lookup().in(Father.class).findSpecial(GrandFather.class, "thinking", mt, Father.class);
                    mh.invoke(this); // i am grandfather
                    //3  LookUp绕过访问保护
                    Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                    lookupImpl.setAccessible(true);
                    mh = ((MethodHandles.Lookup)lookupImpl.get(null))
                            .findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                    mh.invoke(this);// i am grandfather
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        new Test().new Son().thinking();
    }
}
