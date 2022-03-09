package part6;

import part6.model.Order;
import part6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapMain {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1,2,3,7,3,5,9);
        List<Integer> multifyNumberList = numberList.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println("multifyNumberList = " + multifyNumberList);

        List<String> strNumbers = numberList.stream()
                .map(x -> "Number is " + x)
                .collect(Collectors.toList());

        System.out.println("strNumbers = " + strNumbers);


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
        List<String> emailList = users.stream()
                .map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println("emailList = " + emailList);


        Order order1 = new Order();
        order1.setId(1001);
        order1.setStatus(Order.OrderStatus.CREATED);
        order1.setCreateByUserid(101L);
        Order order2 = new Order();
        order2.setId(1002);
        order2.setStatus(Order.OrderStatus.ERROR);
        order2.setCreateByUserid(102L);
        Order order3 = new Order();
        order3.setId(1003);
        order3.setStatus(Order.OrderStatus.ERROR);
        order3.setCreateByUserid(105L);
        Order order4 = new Order();
        order4.setId(1004);
        order4.setStatus(Order.OrderStatus.CREATED);
        order4.setCreateByUserid(102L);
        Order order5 = new Order();
        order5.setId(1005);
        order5.setStatus(Order.OrderStatus.IN_PROGRESS);
        order5.setCreateByUserid(101L);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> createUserIdList = orders.stream()
                .map(Order::getCreateByUserid)
                .collect(Collectors.toList());
        System.out.println("createUserIdList = " + createUserIdList);

    }
}
