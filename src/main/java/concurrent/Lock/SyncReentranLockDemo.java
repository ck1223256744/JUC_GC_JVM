package concurrent.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {

    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void first() {
        lock.lock();
        try {
            //判断
            while (num != 1) {
                c1.await();
            }
            //do
            for (int i = 0; i < 10; i++) {
                System.out.println("Naruto");
            }
            //通知，修改标志位
            num = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second() {
        lock.lock();
        try {
            //判断
            while (num != 2) {
                c2.await();
            }
            //do
            for (int i = 0; i < 10; i++) {
                System.out.println("Sasuke");
            }
            //通知，修改标志位
            num = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            //判断
            while (num != 3) {
                c3.await();
            }
            //do
            for (int i = 0; i < 10; i++) {
                System.out.println("CK");
            }
            //通知，修改标志位
            num = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

public class SyncReentranLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.first();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.second();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareResource.third();
            }
        }, "C").start();
    }
}
