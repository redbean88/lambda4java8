package part8;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMain {
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        Set<Integer> collect1 = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.toSet());
        List<String> collect2 = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.mapping(x -> String.valueOf(x), Collectors.toList()));
        System.out.println("collect2 = " + collect2);
        Set<Integer> collect3 = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
        System.out.println("collect3 = " + collect3);
        List<Integer> collect4 = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println("collect4 = " + collect4);
        Integer collect5 = Stream.of(1, 4, -5, -5, 6, 2)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println("collect5 = " + collect5);
    }
}
