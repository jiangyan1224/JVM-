package invoke_reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

public class Invoke_ReflectTest {
    static class classA{
        public void printUser(){
            System.out.println("classA");
        }
    }

    public static MethodHandle getPrintUserMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        //方法类型，包含方法返回值和方法参数
        MethodType methodType = MethodType.methodType(void.class);
        //lookup()在某个类中查找指定名字和方法类型的方法，返回具有调用权限的方法句柄
        //bindTo绑定this
        return lookup().findVirtual(receiver.getClass(),  "printUser", methodType).bindTo(receiver);
    }
    public static void main(String[] args) throws Throwable {
        //反射reflect
        Class initialClass = Class.forName("invoke_reflect.User");
        Constructor constructor = initialClass.getConstructor(int.class, String.class);
        Object object = constructor.newInstance(12, "jy");
        System.out.println(object.toString());//object的实际类型是User
        Method method = initialClass.getMethod("printUser");
        method.invoke(object);

        //方法句柄invoke
        Object obj = System.currentTimeMillis() % 2 == 0 ? new User(13,"jy") : new classA();
        getPrintUserMH(obj).invokeExact();

    }
}
