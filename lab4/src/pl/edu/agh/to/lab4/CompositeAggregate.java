package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.dataProvider.SuspectAggregate;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.*;

public class CompositeAggregate implements SuspectAggregate {

    private ArrayList<Suspect> suspectDataProvider = new ArrayList<>();
    private Collection<SuspectAggregate> suspectAggregates = new ArrayList<>();

    @Override
    public Iterator<Suspect> iterator() {
        return new Iterator<Suspect>() {

            Iterator<Suspect> iterator = suspectDataProvider.iterator();

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

    public void addCollection(SuspectAggregate newCollection) {
        suspectAggregates.add(newCollection);
    }

    public ArrayList<Suspect> getAllSuspects(){
        for (SuspectAggregate collection : this.suspectAggregates) {
            Iterator<Suspect> suspectedList = collection.iterator();

            while(suspectedList.hasNext()) {
                Suspect suspect = suspectedList.next();
                this.suspectDataProvider.add(suspect);
            }
        }
        return this.suspectDataProvider;
    }
}
