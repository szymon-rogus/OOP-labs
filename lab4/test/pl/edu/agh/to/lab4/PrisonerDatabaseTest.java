package pl.edu.agh.to.lab4;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.dataProvider.PrisonerDataProvider;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonerDataProvider prisonerDataProvider = new PrisonerDataProvider();

    @Before
    public void addExampleData() {
        prisonerDataProvider.addExampleData();
    }
    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonerDataProvider.getPrisons().size());
    }
}
