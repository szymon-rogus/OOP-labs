package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.searchStrategy.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.searchStrategy.SearchStrategy;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Collection;

public class Finder {

    private CompositeAggregate compositeAggregate;
    private CompositeSearchStrategy compositeSearchStrategy;

    public Finder(CompositeAggregate compositeAggregate, CompositeSearchStrategy searchStrategy) {
        this.compositeAggregate = compositeAggregate;
        this.compositeSearchStrategy = searchStrategy;
    }

    public void displayWithActualStrategy() {
        Collection<Suspect> suspected = compositeSearchStrategy.filter(compositeAggregate.getAllSuspects());
        for(Suspect suspect : suspected) {
            System.out.println(suspect.getName() + " " + suspect.getSurname());
        }
    }
}
