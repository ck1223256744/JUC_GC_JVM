package OOM;

import java.util.ArrayList;
import java.util.List;

//-Xms10m -Xmx10m -XX:+PrintGCDetails
public class GClimitExceedDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list=new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("*******************i\t"+i);
        }
    }
}
