package concurrent.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("******come in");
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask, "aaa");
        t1.start();

        new Thread(futureTask,"bbb").start();
//        int result02=futureTask.get();


        System.out.println(Thread.currentThread().getName()+"***************");
        int result01 = 100;



        while (!futureTask.isDone()){

        }

        int result02 = futureTask.get();//建议放在最后，不要阻塞main线程
        System.out.println("result " + (result01+result02));


    }
}
