package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;

public class NameSearchStrategy implements SearchStrategy {

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public Collection<Suspect> filter(Collection<Suspect> suspectList) {
        Collection<Suspect> filteredByName = new ArrayList<>();
        for(Suspect suspect : suspectList) {
            if(suspect.getName().equals(this.name))
                filteredByName.add(suspect);
        }
        return filteredByName;
    }
}
