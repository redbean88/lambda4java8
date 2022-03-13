package part8;

import part6.model.Order;
import part6.model.OrderLine;
import part8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceMain {
    public static void main(String[] args) {
        List<Integer> integerStream = Arrays.asList(1, 4, 5, 6, 2);

        Integer integer = integerStream
                .stream()
                .reduce((x, y) -> x + y)
                .orElse(0);
        System.out.println("integer = " + integer);
        Integer min = integerStream
                .stream()
                .reduce((x, y) -> x > y ? y : x)
                .orElse(0);
        System.out.println("min = " + min);

        Integer multify = integerStream
                .stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println("multify = " + multify);

        List<String> strList = Arrays.asList("1", "4", "5", "6", "2");

        Integer sum = strList.stream()
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y)
                .get();
        System.out.println("sum = " + sum);



        User user1 = new User()
                .setId(101)
                .setName("kim")
                .setVerified(true)
                .setEmailAddress("test@test.com")
                .setFriendUserIds(Arrays.asList(202,211,255));

        User user2 = new User()
                .setId(102)
                .setName("park")
                .setVerified(false)
                .setEmailAddress("test@test2.com")
                .setFriendUserIds(Arrays.asList(211,255));

        User user3 = new User()
                .setId(103)
                .setName("choi")
                .setVerified(false)
                .setEmailAddress("test@test3.com")
                .setFriendUserIds(Arrays.asList(202,215,255));

        List<User> users = Arrays.asList(user1, user2, user3);

        Integer sumFriend = users.stream()
                .map(user -> user.getFriendUserIds())
                .map(List::size)
                .reduce((x,y) -> x + y)
                .get();
        System.out.println("sumFriend = " + sumFriend);


        Order order2 = new Order();
        order2.setId(101);
        order2.setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(1003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(3000)),
                        new OrderLine()
                                .setId(1004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                )
        );


        Order order3 = new Order();
        order3.setId(101);
        order3.setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(1005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                )
        );

        Order order1 = new Order();
        order1.setId(101);
        order1.setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(1001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(1002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                )
        );

        List<Order> orders = Arrays.asList(order1, order2, order3);

        BigDecimal bigDecimal = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce((x, y) -> x.add(y))
                .get();
        System.out.println("bigDecimal = " + bigDecimal);

    }
}
