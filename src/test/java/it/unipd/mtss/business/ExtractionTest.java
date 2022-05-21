////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ExtractionTest {
    Extraction extr = null;
    User user = null;

    @Before
    public void beforeTests() {

        user = new User("Samuel", "Peron", LocalDate.of(2020, 1, 1), "samuperon@icloud.com");
        extr = new Extraction();
    }

    @Test
    public void testControl() {

        assertTrue(extr.extractionControl(user, LocalTime.of(18, 01)));
    }

    @Test
    public void testControlWithoutUser() {

        user = new User("Samuel", "Peron", LocalDate.of(1970, 1, 2), "samuperon@icloud.com");

        assertFalse(extr.extractionControl(user, LocalTime.of(18, 01)));
    }

    @Test
    public void testControlWrongTimestamp() {

        user = new User("Samuel", "Peron", LocalDate.of(2020, 1, 1), "samuperon@icloud.com");

        assertFalse(extr.extractionControl(user, LocalTime.of(16, 20)));
    }

    @Test
    public void testControlTooUsers() throws IllegalArgumentException {

        for (int i = 0; i < 10; i++) {
            extr.users.add(user);
        }

        assertFalse(extr.extract(user, LocalTime.of(18, 04)));
    }

    @Test
    public void testExtract() throws IllegalArgumentException {

        assertTrue(extr.extract(user, LocalTime.of(18, 07)));
    }

    @Test
    public void testExtractWithoutUser() {

        user = null;
        try {
            extr.extract(user, LocalTime.of(18, 01));
        } catch (IllegalArgumentException e) {

            assertEquals("User missing", e.getMessage());
        }
    }

    @Test
    public void testExtractWrongTimestamp() {

        try {
            extr.extract(user, null);
        } catch (IllegalArgumentException e) {

            assertEquals("Timestamp missing", e.getMessage());
        }
    }
}