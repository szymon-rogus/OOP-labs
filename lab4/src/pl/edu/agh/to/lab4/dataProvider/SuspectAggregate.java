package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;

public interface SuspectAggregate extends Iterable<Suspect> {
    Iterator<Suspect> iterator();
}
