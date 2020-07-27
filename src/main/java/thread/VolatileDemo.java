package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int num=0;
    public void add(){
        this.num=60;
    }
    public void addplus(){
        num++;
    }
    AtomicInteger atomicInteger=new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
//        AtomicNotOk();
        seeOkByVolatile();
    }

    private static void AtomicNotOk() {
        MyData myData=new MyData();
        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addplus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"final num"+myData.num);
        System.out.println(Thread.currentThread().getName()+"final atomic"+myData.atomicInteger);
    }

    private static void seeOkByVolatile() {
        MyData myData=new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"add come in");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
            System.out.println(Thread.currentThread().getName()+"update"+myData.num);
        },"aaa").start();

        while (myData.num==0){}
        System.out.println(Thread.currentThread().getName()+"end mission");
    }
}
