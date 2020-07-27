package lambda;

interface Foo{
    void sayHello();
}

@FunctionalInterface
interface Add{
    int adddd(int x, int y);

    default int add2(int x, int y){
        return x+y;
    }

    static void sleep(){

    }
}

public class lambdaDemo {
    public static void main(String[] args) {
//        Foo foo=new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello");
//            }
//        };
//        foo.sayHello();
        Foo foo=()->{
            System.out.println("hello");
        };
//        foo.sayHello();

        Add add=(x, y)->x+y;

        System.out.println(add.adddd(1, 2));
    }
}
