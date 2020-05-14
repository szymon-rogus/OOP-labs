package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Prisoner;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Collection;
import java.util.Iterator;

public class IterablePrisonerDataProvider extends PrisonerDataProvider implements SuspectAggregate {
    private final PrisonerDataProvider prisonerDataProvider;

    public IterablePrisonerDataProvider(PrisonerDataProvider prisonerDataProvider) {
        this.prisonerDataProvider = prisonerDataProvider;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new Iterator<Suspect>() {

            Iterator<Collection<Prisoner>> hashMapIterator = prisonerDataProvider.getPrisoners().values().iterator();
            private Iterator<Prisoner> collectionIterator = hashMapIterator.hasNext() ? hashMapIterator.next().iterator() : null;


            @Override
            public boolean hasNext() {
                if (collectionIterator == null)
                    return false;
                if (collectionIterator.hasNext())
                    return true;
                return hashMapIterator.hasNext();

            }

            @Override
            public Suspect next() {
                if (collectionIterator.hasNext())
                    return collectionIterator.next();
                collectionIterator = hashMapIterator.next().iterator();
                return collectionIterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
