package pl.edu.agh.internetshop.SearchStrategy;

import pl.edu.agh.internetshop.Order;

import java.util.Collection;
import java.util.stream.Collectors;

public class ProductNameStrategy implements SearchStrategy {

    public ProductNameStrategy(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public Collection<Order> filter(Collection<Order> orders) {
        return  orders.stream()
                .filter(order -> order.getProducts()
                        .stream()
                        .anyMatch(product -> product.getName().equals(name)))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
