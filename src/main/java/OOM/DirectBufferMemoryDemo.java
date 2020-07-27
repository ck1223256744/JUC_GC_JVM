package OOM;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
//-XX:MaxDirectMemorySize=5m
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println(sun.misc.VM.maxDirectMemory()/1024/1024+"MB");
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
        ByteBuffer b=ByteBuffer.allocateDirect(9*1024*1024);
    }
}
