package threadSafe;

public class Inner_OutClass {
        public static void main(String[] args){
            String str="haha";
            new Thread() {
                @Override
                public void run() {
                    System.out.println(str);
                }
            }.start();
        }
}
