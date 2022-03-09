package part6;

import part6.model.Order;
import part6.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapMain {
    public static void main(String[] args) {
        String[][] cities = {
                {"Seoul", "Pusan"},
                {"New York", "LA"},
                {"Tokyo"}
        };

        List<String> flatCities = Arrays.stream(cities)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        System.out.println("flatCities = " + flatCities);

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
        List<OrderLine> orderLineList = orders.stream() // Stream<Order>
                .map(Order::getOrderLines)// Stream<List<OrderLine>>
                .flatMap(List::stream)  // Stream<OrderLine>
                .collect(Collectors.toList());
        System.out.println("orderLineList = " + orderLineList);

    }
}
