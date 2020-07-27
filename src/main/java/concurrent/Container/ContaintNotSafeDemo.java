package concurrent.Container;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContaintNotSafeDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        new HashSet<>();
    }

    private static void ListNotSafe() {
        //        List<String> list= Arrays.asList("a","b","c");
//        list.forEach(System.out::println);

        List<String> list=new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();//new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException
        //并发修改异常
    }
}
