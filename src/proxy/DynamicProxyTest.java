package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    //接口
    interface IHello{
       void sayHello();
       void sayName();
    }
    interface IBye{
        void sayBye();
    }

    //被代理类
    static class Hello implements IHello,IBye{
        @Override
        public void sayHello(){
            System.out.println("hello");
        }

        @Override
        public void sayName() {
            System.out.println("jy");
        }

        @Override
        public void sayBye() {
            System.out.println("bye");
        }
    }

    //调用处理器，内部持有被代理类
    static class DynamicProxy implements InvocationHandler{
        Object proxyeeObj;//被代理对象

        //赋值被代理对象，调用Proxy的静态方法，返回一个代理对象实例
        public Object bind(Object proxyeeObj){
            this.proxyeeObj = proxyeeObj;
            //这个方法最终会生成一个$Proxy0.class文件，内含被代理对象实现的所有接口的所有方法Method
            return Proxy.newProxyInstance(proxyeeObj.getClass().getClassLoader(),
                    proxyeeObj.getClass().getInterfaces(),this);
        }

        public DynamicProxy(Object realObj){
            this.proxyeeObj = realObj;
        }
        public DynamicProxy(){}
        //所有执行代理对象的方法，最终都会转化为对这个invoke方法的调用，最终是Method.invoke()方法，调用实际被代理对象实例的对应方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxyee method start!");
            method.invoke(proxyeeObj, args);//方法的动态分派
            System.out.println("proxyee method completed!");
            return null;
        }
    }

    //使用
    public static void main(String[] args){
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        Hello helloObj = new Hello();//被代理类的实例
        //这里proxyHandler静态类型不能写InvocationHandler。就算方法版本最终看的是对象的实际类型，但是在编译成的class文件中
        //写的方法描述符写的也是父类InvocationHandler，更何况bind方法本来就不存在于父类InvocationHandler
//        InvocationHandler proxyHandler = new DynamicProxy();
        DynamicProxy proxyHandler = new DynamicProxy();//调用代理器的实例
        IBye helloProxy = (IBye) proxyHandler.bind(new Hello());
        IHello helloProxy1 = (IHello) proxyHandler.bind(new Hello());
        helloProxy1.sayHello();
        helloProxy1.sayName();
        helloProxy.sayBye();
        //
        System.out.println("---");
        Hello hello = new Hello();
        proxyHandler = new DynamicProxy(hello);
        helloProxy = (IBye) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), proxyHandler);
        helloProxy.sayBye();
    }
}
