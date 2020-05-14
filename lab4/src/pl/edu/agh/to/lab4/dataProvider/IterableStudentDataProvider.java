package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Student;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;

public class IterableStudentDataProvider extends StudentDataProvider implements SuspectAggregate {

    private final StudentDataProvider studentDataProvider;

    public IterableStudentDataProvider(StudentDataProvider studentDataProvider) {
        this.studentDataProvider = studentDataProvider;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new Iterator<Suspect>() {

            Iterator<Student> iterator = studentDataProvider.getStudents().iterator();

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
