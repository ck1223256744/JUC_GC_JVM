package communication;

class AirConditioner{
    private int number=0;
    private int n=97;
    private int m=1;

    public synchronized void alpha() throws InterruptedException {
        //判断
        while (number==2){
            this.wait();
        }
        //do
        number++;

        System.out.println(Thread.currentThread().getName()+"\t"+(char)n++);
        //通知
        this.notifyAll();
    }

    public synchronized void digit() throws InterruptedException {
        while (number!=2){
            this.wait();
        }

        number=0;
        System.out.println(Thread.currentThread().getName()+"\t"+m++);
        this.notifyAll();
    }
}

public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner=new AirConditioner();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    airConditioner.alpha();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"aaa").start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                try {
                    airConditioner.digit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"bbb").start();


    }
}
