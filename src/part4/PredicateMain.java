package part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;

        List<Integer> lists = Arrays.asList(1,-1,2,5,10,-20, 0);
        List<Integer> positive = filter(lists, isPositive);
        System.out.println("positive = " + positive);
        List<Integer> negative = filter(lists, isPositive.negate());
        System.out.println("negative = " + negative);
        List<Integer> positiveOrZero = filter(lists, isPositive.or( x -> x == 0));
        System.out.println("positiveOrZero = " + positiveOrZero);
        List<Integer> positiveEven = filter(lists, isPositive.and( x -> x % 2 == 0));
        System.out.println("positiveEven = " + positiveEven);
    }

    public static <T> List<T> filter(List<T> list , Predicate<T> condition){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (condition.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
