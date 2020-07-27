package reference;

import java.lang.ref.SoftReference;

public class ReferenceDemo {
    public static void main(String[] args) {
        Object o1=new Object();
//        Object o2=o1;//强引用
        SoftReference<Object> softReference=new SoftReference<>(o1);//软引用
//        System.out.println(o2);
        System.out.println("软"+softReference.get());

        o1=null;


        try {
//            byte[] bytes=new byte[30*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            System.out.println("强"+o2);
            System.out.println("软"+softReference.get());
        }

        while (true){}
    }
}
