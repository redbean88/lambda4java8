package part5;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class MethodReference1 {
    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multipy(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public void subtrachMethod(int x, int y) {
        System.out.println(calculate(x, y , this::subtract));
    }

    public static void main(String[] args) {

        int a = Integer.parseInt("15");
        System.out.println("a = " + a);

        Function<String, Integer> str2int = Integer::parseInt;
        System.out.println(str2int.apply("20"));

        ToIntFunction<String> function = Integer::parseInt;
        int anInt = function.applyAsInt("15");
        System.out.println("anInt = " + anInt);

        String str = "hello";
        boolean world = str.equals("world");
        Predicate<String> equalsToHello = str::equals;
        boolean hello = equalsToHello.test("hello");
        System.out.println("hello = " + hello);

        System.out.println(calculate(2, 4, (x, y) -> x + y));

        System.out.println(calculate(4, 2, MethodReference1::multipy));

        MethodReference1 instance = new MethodReference1();
        System.out.println(calculate(8, 3, instance::subtract));
        instance.subtrachMethod(8,3);

    }
}
