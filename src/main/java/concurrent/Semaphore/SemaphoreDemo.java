package concurrent.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+"\t get the location");

                    try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

                    System.out.println(Thread.currentThread().getName()+"\t leave the location");

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }finally {

                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
