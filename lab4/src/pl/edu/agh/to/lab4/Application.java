package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.dataProvider.*;
import pl.edu.agh.to.lab4.searchStrategy.AgeSearchStrategy;
import pl.edu.agh.to.lab4.searchStrategy.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.searchStrategy.NameSearchStrategy;

public class Application {

    public static void main(String[] args) {
        CitizenDataProvider citizenDataProvider = new CitizenDataProvider();
        citizenDataProvider.addExampleData();
        PrisonerDataProvider prisonerDataProvider = new PrisonerDataProvider();
        prisonerDataProvider.addExampleData();
        StudentDataProvider studentDataProvider = new StudentDataProvider();
        studentDataProvider.addExampleData();

        CompositeAggregate compositeAggregate = new CompositeAggregate();

        compositeAggregate.addCollection(new IterableCitizenDataProvider(citizenDataProvider));
        compositeAggregate.addCollection(new IterablePrisonerDataProvider(prisonerDataProvider));
        compositeAggregate.addCollection(new IterableStudentDataProvider(studentDataProvider));

        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy();
        AgeSearchStrategy ageSearchStrategy = new AgeSearchStrategy(18);
        NameSearchStrategy nameSearchStrategy = new NameSearchStrategy("Janusz");

        compositeSearchStrategy.addStrategy(ageSearchStrategy);
        compositeSearchStrategy.addStrategy(nameSearchStrategy);

        Finder suspects = new Finder(compositeAggregate, compositeSearchStrategy);

        suspects.displayWithActualStrategy();
    }
}
