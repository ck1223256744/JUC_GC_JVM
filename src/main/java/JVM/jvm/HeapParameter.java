package JVM.jvm;

public class HeapParameter {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory=Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx maxMemory: "+maxMemory+"bytes\t"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("-Xms totalMemory: "+totalMemory+"bytes\t"+(totalMemory/(double)1024/1024)+"MB");
//        String str="ck";
//        while (true){
//            str+=str+new Random().nextInt(9999999)+new Random().nextInt(999999999);
//        }
    }
}
