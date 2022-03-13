package part8;

import part8.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1231, 45345, 62, 2, 3, 4, 65, 16, 3, 4, 4361, 234, 2356);
        Map<Integer, List<Integer>> collect = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println("collect = " + collect);

        Map<Integer, Set<Integer>> setMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println("setMap = " + setMap);

        Map<Integer, List<String>> strList = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.mapping(number -> "Number is " + number, Collectors.toList())));

        System.out.println("strList = " + strList);


        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

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

        Map<Order.OrderStatus, List<Order>> collectedMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println("collectedMap = " + collectedMap);

        Map<Order.OrderStatus, BigDecimal> collect1 = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println("collect1 = " + collect1);
    }

}
