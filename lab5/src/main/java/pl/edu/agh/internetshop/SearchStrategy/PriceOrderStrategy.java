package pl.edu.agh.internetshop.SearchStrategy;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

public class PriceOrderStrategy implements SearchStrategy {

    private BigDecimal price;

    public PriceOrderStrategy(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Collection<Order> filter(Collection<Order> orders) {
        return orders.stream()
                .filter(order -> order.getPrice().compareTo(price) == 0)
                .collect(Collectors.toList());
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
