package concurrent.Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendSMS");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke email");
    }

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\tinvoke get");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\tinvoke set");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ReentranLockDemo {

    public static void main(String[] args) throws Exception{
        Phone phone=new Phone();
//        new concurrent.Volatile(()->{
//            try {
//                phone.sendSMS();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"t1").start();
//        new concurrent.Volatile(()->{
//            try {
//                phone.sendSMS();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },"t2").start();

        new Thread(()->{
            phone.get();
        },"t3").start();

        new Thread(()->{
            phone.get();
        },"t4").start();
    }
}
