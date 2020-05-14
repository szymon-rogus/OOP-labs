package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CompositeSearchStrategy implements SearchStrategy {

    private Collection<SearchStrategy> searchStrategies = new ArrayList<>();

    public void addStrategy(SearchStrategy newStrategy) {
        searchStrategies.add(newStrategy);
    }

    @Override
    public Collection<Suspect> filter(Collection<Suspect> suspect) {
        Collection<Suspect> suspectsFiltered = suspect.stream().filter(Suspect::canBeSuspect).collect(Collectors.toList());

        for(SearchStrategy searchStrategy : searchStrategies) {
            suspectsFiltered = searchStrategy.filter(suspectsFiltered);
        }

        return suspectsFiltered;
    }
}

