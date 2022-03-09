package part6;

import part6.model.Order;
import part6.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterMain {
    public static void main(String[] args) {
        Stream<Integer> intStream = Stream.of(1,23,23, 12, 5, 6,8);
        Stream<Integer> filteredintegerStream = intStream.filter(x -> x > 10);
        List<Integer> filteredIntegers = filteredintegerStream.collect(Collectors.toList());
        System.out.println("filteredIntegers = " + filteredIntegers);

        List<Integer> filteredIntergers2 = Stream.of(1,23,23, 12, 5, 6,8)
                .filter(x -> x > 10)
                .collect(Collectors.toList());
        System.out.println("filteredIntergers2 = " + filteredIntergers2);

        User user1 = new User()
                .setId(101)
                .setName("kim")
                .setVerified(true)
                .setEmailAddress("test@test.com");

        User user2 = new User()
                .setId(102)
                .setName("park")
                .setVerified(false)
                .setEmailAddress("test@test.com");

        User user3 = new User()
                .setId(103)
                .setName("choi")
                .setVerified(false)
                .setEmailAddress("test@test.com");

        List<User> userList = Arrays.asList(user1 , user2 , user3);
        List<User> fiteredUserList = userList.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
        System.out.println("fiteredUserList = " + fiteredUserList);

        List<User> fiteredUserList2 = userList.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println("fiteredUserList2 = " + fiteredUserList2);

        Order order1 = new Order();
        order1.setId(1001);
        order1.setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order();
        order2.setId(1002);
        order2.setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order();
        order3.setId(1003);
        order3.setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order();
        order4.setId(1004);
        order4.setStatus(Order.OrderStatus.CREATED);
        Order order5 = new Order();
        order5.setId(1005);
        order5.setStatus(Order.OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Order> fiteredOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .collect(Collectors.toList());

        System.out.println("fiteredOrders = " + fiteredOrders);

    }
}
