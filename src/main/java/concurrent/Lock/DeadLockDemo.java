package concurrent.Lock;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t"+lockA+" want get "+lockB);
            try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t"+lockB+" want get "+lockA);
            }
        }
    }

    private String lockA;
    private String lockB;
}


public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA="lockA";
        String lockB="lockB";

        new Thread(new HoldLockThread(lockA,lockB),"aaa").start();
        new Thread(new HoldLockThread(lockB,lockA),"bbb").start();
    }
}
