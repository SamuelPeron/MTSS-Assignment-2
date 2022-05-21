////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UserTest {

    User user;

    @Before
    public void initialize() {
        user = new User("Mattia", "Brunello", LocalDate.of(2001, 12, 21), "mattia@email.com");
    }

    @Test
    public void testGetName() {
        assertEquals("Mattia", user.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Brunello", user.getSurname());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals(LocalDate.of(2001, 12, 21), user.getDateOfBirth());
    }

    @Test
    public void testGetEmail() {
        assertEquals("mattia@email.com", user.getEmail());
    }

    @Test
    public void testIllegalDateOfBirth() {
        try {
            new User("Mattia", "Brunello", LocalDate.now().plusDays(10), "mattia@email.com");
        } catch (IllegalArgumentException e) {
            assertEquals("La data di nascita deve essere precedente alla data odierna", e.getMessage());
        }
    }

    @Test
    public void testNullDateOfBirth() {
        try {
            new User("Mattia", "Brunello", null, "mattia@email.com");
        } catch (IllegalArgumentException e) {
            assertEquals("La data di nascita è null", e.getMessage());
        }
    }

}