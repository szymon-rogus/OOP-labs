package pl.edu.agh.internetshop.SearchStrategy;

import pl.edu.agh.internetshop.Order;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy {

    private static Collection<SearchStrategy> searchStrategies = new ArrayList<>();

    public static Collection<SearchStrategy> getSearchStrategies() {
        return searchStrategies;
    }

    public static void setSearchStrategies(Collection<SearchStrategy> searchStrategies) {
        CompositeSearchStrategy.searchStrategies = searchStrategies;
    }

    public void addStrategy(SearchStrategy searchStrategy) {
        searchStrategies.add(searchStrategy);
    }

    @Override
    public Collection<Order> filter(Collection<Order> orders) {
        Collection<Order> ordersFiltered = new ArrayList<>(orders);

        for(SearchStrategy searchStrategy : searchStrategies) {
            ordersFiltered = searchStrategy.filter(ordersFiltered);
        }

        return ordersFiltered;
    }
}
