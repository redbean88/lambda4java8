package part9;

import com.sun.org.apache.xpath.internal.operations.Or;
import part9.model.Order;
import part9.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionCompositionMain {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyTwo = x -> x*2;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> compositionFunction = multiplyTwo.andThen(addTen);
        Integer result = compositionFunction.apply(2);
        System.out.println("result = " + result);

        Order unprocessedOrder = new Order()
                .setId(100L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))
                        )
                );

        List<Function<Order, Order>> priceProcessor = getPriceProcessors(unprocessedOrder);
        
        Function<Order ,Order> mergedPriceProcessor = priceProcessor.stream()
                .reduce(Function.identity(), Function::andThen);

        Order apply = mergedPriceProcessor.apply(unprocessedOrder);
        System.out.println("apply.getAmount() = " + apply.getAmount());

    }
    public static List<Function<Order, Order>> getPriceProcessors(Order order){
        return Arrays.asList(new OrderLineAggregationprocessor(), new TaxProcessor());
    };
}
