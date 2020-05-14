package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;

public class AgeSearchStrategy implements SearchStrategy {

    public AgeSearchStrategy(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    private int minimalAge;

    @Override
    public Collection<Suspect> filter(Collection<Suspect> suspectList) {
        Collection<Suspect> filteredByAge = new ArrayList<>();
        for(Suspect suspect : suspectList) {
            if(suspect.getAge() >= this.minimalAge)
                filteredByAge.add(suspect);
        }
        return filteredByAge;
    }
}
