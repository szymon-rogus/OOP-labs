package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Collection;

public interface SearchStrategy {

    Collection<Suspect> filter(Collection<Suspect> suspect);
}
