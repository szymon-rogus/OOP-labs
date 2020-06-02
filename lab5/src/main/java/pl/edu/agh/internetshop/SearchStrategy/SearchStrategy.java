package pl.edu.agh.internetshop.SearchStrategy;

import pl.edu.agh.internetshop.Order;

import java.util.Collection;

public interface SearchStrategy {

    Collection<Order> filter(Collection<Order> orders);
}
