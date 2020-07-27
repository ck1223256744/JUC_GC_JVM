package concurrent.CountDownLatch;

import concurrent.enums.LovEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private static final int num = 3;
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch=new CountDownLatch(num);
        for (int i = 1; i <= 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t lov");
                countDownLatch.countDown();
            }, LovEnum.forEach_Lov(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t all lov");
    }
}
