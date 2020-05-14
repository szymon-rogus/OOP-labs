package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.model.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 21, 2011, 15);
        assertTrue(news.isJailedNow());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 21,2008, 5);
        assertFalse(news.isJailedNow());
    }
}
