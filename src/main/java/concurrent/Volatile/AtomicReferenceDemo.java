package concurrent.Volatile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User{
    String UserName;
    int age;
}


public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User ck1=new User("ck1",20);
        User ck2=new User("ck2",23);

        AtomicReference<User> atomicReference=new AtomicReference<>();
        atomicReference.set(ck1);

        System.out.println(atomicReference.compareAndSet(ck1, ck2)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(ck1, ck2)+"\t"+atomicReference.get().toString());
    }
}
