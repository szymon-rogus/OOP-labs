package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Person;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;

public class IterableCitizenDataProvider extends CitizenDataProvider implements SuspectAggregate {
    private final CitizenDataProvider citizenDataProvider;

    public IterableCitizenDataProvider(CitizenDataProvider citizenDataProvider) {
        this.citizenDataProvider = citizenDataProvider;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new Iterator<Suspect>() {

            Iterator<Person> iterator = citizenDataProvider.getCitizens().iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Suspect next() {
                return iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
