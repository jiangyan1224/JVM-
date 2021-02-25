package gc;

public class FieldHasNoPolymorphic {
    static class Father{
        public int money = 1;
        Father(){
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney(){
            System.out.println("father has money "+money);
        }
    }
    static class Son extends Father{
        public int money = 3;
        Son(){
            money = 4;
            showMeTheMoney();
        }
        public void showMeTheMoney(){
            System.out.println("son has money "+money);
        }
    }
    public static void main(String[] args){
        Father guy = new Son();
        System.out.println(guy.money);
        Father fa = new Father();
//        fa.func();
    }
}
