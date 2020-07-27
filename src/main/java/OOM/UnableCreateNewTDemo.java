package OOM;//package OOM;
//
//import java.util.concurrent.TimeUnit;
//
//public class UnableCreateNewTDemo {
//    public static void main(String[] args) {
//        for (int i = 0; ; i++) {
//            System.out.println("*************i:  "+i);
//            new Thread(()->{
//                try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace();}
//            },""+i).start();
//        }
//    }
//}


//Use on Linux with a not-root login