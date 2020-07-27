package stream;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
    private int id;
    private String userName;
    private int age;
}

public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);


        list.stream().filter(p -> {
            return p.getId() % 2 == 0;
        }).filter(p -> {
            return p.getAge() > 24;
        }).map(f -> {
            return f.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);
    }

    private static void Interface4() {
        //Function
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };
        function.apply("A");

        Function<String, Integer> function2 = s -> s.length();
        function2.apply("string");


        //Predicate
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        Predicate<String> predicate2 = s -> s.isEmpty();
        System.out.println(predicate.test("as"));

        //Consumer
        Consumer<String> consumer = s -> {
            System.out.println("yes");
        };

        consumer.accept("s");

        //Supplier
        Supplier<String> supplier=()->"s";
        supplier.get();
    }
}


