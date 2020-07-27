package concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        blockingQueue.offer("a");
//        blockingQueue.offer("b");
//        blockingQueue.offer("c");
//        blockingQueue.offer("a");
//
//        blockingQueue.peek();
//        blockingQueue.peek();
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());


//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        System.out.println("================");


//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));

    }
}
