package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.dataProvider.CitizenDataProvider;
import pl.edu.agh.to.lab4.dataProvider.IterableCitizenDataProvider;
import pl.edu.agh.to.lab4.dataProvider.IterablePrisonerDataProvider;
import pl.edu.agh.to.lab4.dataProvider.PrisonerDataProvider;
import pl.edu.agh.to.lab4.searchStrategy.AgeSearchStrategy;
import pl.edu.agh.to.lab4.searchStrategy.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.searchStrategy.NameSearchStrategy;
import pl.edu.agh.to.lab4.model.Person;
import pl.edu.agh.to.lab4.model.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private final CitizenDataProvider citizenDataProvider = new CitizenDataProvider();

    private final PrisonerDataProvider prisonerDataProvider = new PrisonerDataProvider();

    private CompositeAggregate compositeAggregate = new CompositeAggregate();

    private CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy();
    private AgeSearchStrategy ageSearchStrategy = new AgeSearchStrategy(18);
    private NameSearchStrategy nameSearchStrategy = new NameSearchStrategy("Jan");

    private Finder suspectFinder = new Finder(compositeAggregate, compositeSearchStrategy);

    @Before
    public void prepareFinder() {
        compositeAggregate.addCollection(new IterableCitizenDataProvider(citizenDataProvider));
        compositeAggregate.addCollection(new IterablePrisonerDataProvider(prisonerDataProvider));
        compositeSearchStrategy.addStrategy(ageSearchStrategy);
        compositeSearchStrategy.addStrategy(nameSearchStrategy);
    }
    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonerDataProvider.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", "802104543357", 25, 2000, 1));
        suspectFinder.displayWithActualStrategy();
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        citizenDataProvider.addCitizen(new Person("Jan", "Kowalski", 21));
        suspectFinder.displayWithActualStrategy();
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        citizenDataProvider.addCitizen(new Person("Jan", "Kowalski", 17));
        suspectFinder.displayWithActualStrategy();
        assertContentIsNotDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        citizenDataProvider.addCitizen(new Person("Jan", "Kowalski", 25));
        prisonerDataProvider.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 45,2000, 30));
        suspectFinder.displayWithActualStrategy();
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

}
