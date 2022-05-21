////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.EItem.itemType;

public class BillImplementationTest {
    public List<EItem> itemsOrdered;
    public BillImplementation bill;
    public User user;

    @Before
    public void setUp() throws Exception {
        bill = new BillImplementation();
        user = new User("Mattia", "Brunello", LocalDate.of(2001, 12, 21), "mattia@email.com");
        itemsOrdered = new ArrayList<EItem>();
    }

    @Test
    public void testGetOrderPrice() throws BillException {

        EItem cpu = new EItem(itemType.PROCESSOR, 30, "Ryzen 5 2600");
        EItem motheboard = new EItem(itemType.MOTHERBOARD, 40, "Asus B450");
        EItem keyboard = new EItem(itemType.KEYBOARD, 40, "Asus B450");

        itemsOrdered.add(cpu);
        itemsOrdered.add(motheboard);
        itemsOrdered.add(keyboard);
        assertEquals(110.0, bill.getOrderPrice(itemsOrdered, user), 1e-15);
    }

}