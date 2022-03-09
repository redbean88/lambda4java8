package part5;

import part5.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReference2 {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello world");
        System.out.println("length = " + length);

        BiPredicate<String, String> strEquals = String::equals;
        System.out.println(strEquals.test("hello", "world"));

        List<User> list = new ArrayList<>();
        list.add(new User(10, "Alice"));
        list.add(new User(22, "Bob"));
        list.add(new User(4, "John"));
        list.add(new User(9, "Ren"));

        printuserfield(list , User::getId);

    }

    public static void printuserfield(List<User> list, Function<User, Object> getter) {
        for (User user : list) {
            System.out.println(getter.apply(user));
        }
    }

}
