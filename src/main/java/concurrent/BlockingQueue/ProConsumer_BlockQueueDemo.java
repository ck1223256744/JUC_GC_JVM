package concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void Prod() throws Exception {

        String data = null;
//        boolean retValue = true;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
//            if(retValue){
            System.out.println(Thread.currentThread().getName() + "\t into the queue" + data + " success");
//            }else {
//                System.out.println(Thread.currentThread().getName()+"\t fail");
//            }

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\tflag=false");
    }

    public void Cons() throws Exception {

        String data = null;

        while (flag) {
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == data || data.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t timeout exit");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t get" + data + " success");
        }
    }

    public void stop() throws Exception {
        this.flag = false;
    }

}

public class ProConsumer_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyData myData = new MyData(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t start");
            try {
                myData.Prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t start");
            System.out.println();
            System.out.println();

            try {
                myData.Cons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Con").start();

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("main stop!");

        myData.stop();
    }
}
