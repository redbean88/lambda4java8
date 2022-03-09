package part6;

import part6.model.Order;
import part6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, -5, 4, 8);
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList);


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
        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        System.out.println("sortedUsers = " + sortedUsers);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order();
        order1.setId(1001);
        order1.setStatus(Order.OrderStatus.CREATED);
        order1.setCreateByUserid(101L);
        order1.setCreateAt(now);
        Order order2 = new Order();
        order2.setId(1002);
        order2.setStatus(Order.OrderStatus.ERROR);
        order2.setCreateByUserid(102L);
        order2.setCreateAt(now.minusHours(4));
        Order order3 = new Order();
        order3.setId(1003);
        order3.setStatus(Order.OrderStatus.ERROR);
        order3.setCreateByUserid(105L);
        order3.setCreateAt(now.minusHours(25));
        Order order4 = new Order();
        order4.setId(1004);
        order4.setStatus(Order.OrderStatus.CREATED);
        order4.setCreateByUserid(102L);
        order4.setCreateAt(now.minusDays(1));
        Order order5 = new Order();
        order5.setId(1005);
        order5.setStatus(Order.OrderStatus.IN_PROGRESS);
        order5.setCreateByUserid(101L);
        order5.setCreateAt(now.minusHours(36));

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        List<Order> sortedCreateAt = orders.stream()
                .sorted((o1, o2) -> o1.getCreateAt().compareTo(o2.getCreateAt()))
                .collect(Collectors.toList());
        System.out.println("sortedCreateAt = " + sortedCreateAt);


    }
}
