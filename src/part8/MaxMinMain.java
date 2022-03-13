package part8;

import part6.model.Order;
import part8.model.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MaxMinMain {
    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(1, 4, 5, 6, 2)
                .max(Integer::compareTo);
        System.out.println("max = " + max.get());


        User user1 = new User()
                .setId(101)
                .setName("kim")
                .setVerified(true)
                .setEmailAddress("test@test.com");

        User user2 = new User()
                .setId(102)
                .setName("park")
                .setVerified(false)
                .setEmailAddress("test@test2.com");

        User user3 = new User()
                .setId(103)
                .setName("choi")
                .setVerified(false)
                .setEmailAddress("test@test3.com");

        List<User> users = Arrays.asList(user1, user2, user3);


        User user = users.stream()
                .min((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .get();

        System.out.println("user = " + user);

        long count = Stream.of(-1, 2, 5, -8, 7)
                .filter(x -> x > 0)
                .count();
        System.out.println("count = " + count);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreateAt(now.minusDays(2));
        user2.setCreateAt(now.minusHours(10));
        user3.setCreateAt(now.minusDays(1));

        long filteredUsers = users.stream()
                .filter(u -> u.getCreateAt().isAfter(now.minusDays(1)))
                .filter(u -> !user.isVerified())
                .count();
        System.out.println("filteredUsers = " + filteredUsers);


        Order order1 = new Order();
        order1.setId(1001);
        order1.setStatus(Order.OrderStatus.CREATED);
        order1.setCreateByUserid(101L);
        order1.setCreateAt(now);
        order1.setAmount(BigDecimal.valueOf(3000));
        Order order2 = new Order();
        order2.setId(1002);
        order2.setStatus(Order.OrderStatus.ERROR);
        order2.setAmount(BigDecimal.valueOf(4000));
        order2.setCreateByUserid(102L);
        order2.setCreateAt(now.minusHours(4));
        Order order3 = new Order();
        order3.setId(1003);
        order3.setStatus(Order.OrderStatus.ERROR);
        order3.setAmount(BigDecimal.valueOf(5000));
        order3.setCreateByUserid(105L);
        order3.setCreateAt(now.minusHours(25));
        Order order4 = new Order();
        order4.setId(1004);
        order4.setStatus(Order.OrderStatus.CREATED);
        order4.setCreateByUserid(102L);
        order4.setAmount(BigDecimal.valueOf(6000));
        order4.setCreateAt(now.minusDays(1));
        Order order5 = new Order();
        order5.setId(1005);
        order5.setStatus(Order.OrderStatus.IN_PROGRESS);
        order5.setAmount(BigDecimal.valueOf(7000));
        order5.setCreateByUserid(101L);
        order5.setCreateAt(now.minusHours(36));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        Order order6 = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .get();
        System.out.println("order6 = " + order6);

        BigDecimal maxAcount = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(order -> order.getAmount())
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.valueOf(0));

        System.out.println("maxAcount = " + maxAcount);

    }
}
