package part9;

import part9.model.Order;
import part9.model.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class TaxProcessor implements Function<Order, Order> {
    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getAmount().multiply(BigDecimal.valueOf(0.8)));
    }
}
