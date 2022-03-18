package part9.model;

import part9.model.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private LocalDateTime createAt;
    private long createByUserid;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    public enum OrderStatus {
        CREATED,
        IN_PROGRESS,
        ERROR,
        PROGRESSED
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public long getCreateByUserid() {
        return createByUserid;
    }

    public void setCreateByUserid(long createByUserid) {
        this.createByUserid = createByUserid;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Order setAmount(BigDecimal amount) {
        this.amount = amount; return this;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Order setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createByUserid=" + createByUserid +
                ", status=" + status +
                ", amount=" + amount +
                ", orderLines=" + orderLines +
                '}';
    }
}
