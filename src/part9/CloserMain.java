package part9;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CloserMain {
    public static void main(String[] args) {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = (x , y) -> x + y;
        Function<Integer, Function<Integer , Integer>> curridAdd = x ->  y -> x + y;

        Function<Integer, Integer> addTree = curridAdd.apply(3);
        int result = addTree.apply(10);
        System.out.println(" result is 13 = " + curridAdd.apply(10));

    }

    public static Supplier<String> getStringSupplier()  {
        String hello = "hello";
        Supplier<String> supplier = () -> {
            String world = "world";
            return hello + world;
        };
        return supplier;
    }
}
