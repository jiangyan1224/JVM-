package gc;

import java.util.ArrayList;
import java.util.List;

public class GC {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            List<String> list = new ArrayList<String>();
            list.add("aaaaaaa");
            list = null;
        }
        System.gc();
    }
}
