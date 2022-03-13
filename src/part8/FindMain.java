package part8;

import java.util.Optional;
import java.util.stream.Stream;

public class FindMain {
    public static void main(String[] args) {
        Optional<Integer> any = Stream.of(1, 0, -9, -3, -7, -8)
                .filter(x -> x < 0)
                .findAny();
        System.out.println("any.get() = " + any.get());

        Optional<Integer> any2 = Stream.of(-1, 0, -9, 3, 7, -8)
                .filter(x -> x > 0)
                .findFirst();

        System.out.println("any2.get() = " + any2.get());
    }
}
