package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.SearchStrategy.CompositeSearchStrategy;

import java.util.ArrayList;
import java.util.Collection;

public class OrdersHistory {

    public static Collection<Order> getOrdersHistory() {
        return ordersHistory;
    }

    private static Collection<Order> ordersHistory = new ArrayList<>();

    public static CompositeSearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    private static CompositeSearchStrategy searchStrategy = new CompositeSearchStrategy();

    public static void add(Order order) {
        ordersHistory.add(order);
    }

    public Collection<Order> getOrdersByStrategy() {
        return searchStrategy.filter(ordersHistory);
    }
}
