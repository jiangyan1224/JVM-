package memModel_threads;

public class DCLTest {
    private static volatile DCLTest dclTest = null;
    private DCLTest(){}
    public static DCLTest getDclTest(){
        if(dclTest == null){
            synchronized (DCLTest.class){
                if(dclTest == null) dclTest = new DCLTest();
            }
        }
        return dclTest;
    }

    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(DCLTest.getDclTest().hashCode());
                }
            }).start();
        }
    }
}
