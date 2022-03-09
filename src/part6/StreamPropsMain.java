package part6;

import part6.model.Order;
import part6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPropsMain {
    public static void main(String[] args) {

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


        List<User> users = Arrays.asList(user1 , user2 , user3);

        List<String> emails = new ArrayList<>();
        for (User user : users){
            if(user.isVerified()){
                emails.add(user.getEmailAddress());
            }
        }
        System.out.println("emails = " + emails);

        List<String> emailList = users.stream()
                .filter(User::isVerified)
                .map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println("emailList = " + emailList);


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

        List<Long> fiteredOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreateByUserid)
                .collect(Collectors.toList());
        System.out.println("fiteredOrders = " + fiteredOrders);

        List<Long> fiteredOrders2 = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreateAt().isAfter(now.minusHours(24)))
                .map(Order::getCreateByUserid)
                .collect(Collectors.toList());
        System.out.println("fiteredOrders2 = " + fiteredOrders2);
    }
}
