package part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {

        Consumer<String> myStringConsumer = str -> System.out.println("str = " + str);

        myStringConsumer.accept("hello");

        List<Integer> list = Arrays.asList(1,2,3);

        Consumer<Integer> multi = integer -> System.out.println("integer = " + integer);
        processor(list , multi);
    }

    public static <T> void processor(List<T> integers , Consumer<T> consumer){
        for (T integer: integers) {
            consumer.accept(integer);
        }
    }
}
