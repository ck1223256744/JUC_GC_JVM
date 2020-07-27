package OOM;

import java.util.Random;
//-Xms10m -Xmx10m
public class JavaHeapErrorDemo {
    public static void main(String[] args) {
        String str="ck";
        while (true){
            str+=str+new Random().nextInt(111111111);
        }
    }
}
