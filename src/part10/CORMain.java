package part10;

import java.util.Optional;
import java.util.function.Consumer;

public class CORMain {
    public static void main(String[] args) {
        OderProcessStep init = new OderProcessStep(order -> {
            order.setName(order.getName() + "start");
        });

        OderProcessStep addTwo = new OderProcessStep(order -> {
            order.setName(order.getName() + "2");
        });

        OderProcessStep addThree = new OderProcessStep(order -> {
            order.setName(order.getName() + "3");
        });

        Order order = new Order();
        order.setName("32");

        OderProcessStep oderProcessStep = init.setNext(addTwo).setNext(addThree);
        oderProcessStep.process(order);
        System.out.println("order.getName() = " + order.getName());

    }
}

class OderProcessStep {
    private final Consumer<Order> processOrder;
    private OderProcessStep next;

    OderProcessStep(Consumer<Order> processOrder) {
        this.processOrder = processOrder;
    }

    public OderProcessStep setNext(OderProcessStep next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
        return this;
    }

    public void process(Order order) {
        processOrder.accept(order);
        Optional.ofNullable(next)
                .ifPresent(nextStep -> nextStep.process(order));
    }
}


class Order {
    String name;
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}