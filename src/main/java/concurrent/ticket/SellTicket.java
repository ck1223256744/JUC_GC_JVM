package concurrent.ticket;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 30;
    private Lock lock = new ReentrantLock();

//    public void sellTicket() {
//        if (number > 0) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "\t sell the " + (number--) + " ticket \t" + number + " left");
//        }
//    }

    public void sellTicket() {
        lock.lock();
        try {
            if (number > 0) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + "\t sell the " + (number--) + " ticket \t" + number + " left");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class SellTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.sellTicket();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ticket.sellTicket();
            }
        }, "B").start();
    }
}
