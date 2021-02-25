package invoke_reflect;

import lombok.Data;

@Data
public class User {
    private int age = 12;
    private String name;
    {
        System.out.println("实例代码块赋值之前的age："+age);
        age = 23;
        System.out.println("实例代码块赋值之后的age："+age);
    }
    public User(int age, String name){
        System.out.println("构造方法赋值之前的age："+age);
        age = 45;
        this.age = age;
        this.name = name;
        System.out.println("构造方法赋值之后的age："+age);
    }

    public User() {
        System.out.println("构造方法赋值之前的age："+age);
        age = 34;
        System.out.println("构造方法赋值之后的age："+age);
    }

    @Override
    public String toString(){
        return age + name;
    }
    public void printUser(){
        System.out.println(toString());
    }

}
