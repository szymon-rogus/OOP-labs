package pl.edu.agh.internetshop.SearchStrategy;

import pl.edu.agh.internetshop.Order;

import java.util.Collection;
import java.util.stream.Collectors;

public class ClientNameStrategy implements SearchStrategy {

    private String name;

    public ClientNameStrategy(String name) {
        this.name = name;
    }

    @Override
    public Collection<Order> filter(Collection<Order> orders) {
        return orders.stream()
                .filter(order -> order.getShipment().getRecipientAddress().getName().equals(name))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
