package concurrent.ThreadPool;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(2,
                                    4,
                                    1L,
                                    TimeUnit.SECONDS,
                                    new LinkedBlockingQueue<Runnable>(3),
                                    Executors.defaultThreadFactory(),
                                    new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t dododo");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void ThreadPoolInit() {
        ExecutorService threadPool= Executors.newCachedThreadPool();
        ExecutorService threadPool2= Executors.newSingleThreadExecutor();
        ExecutorService threadPool3= Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t dododo");
                });
//                try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace();}
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
