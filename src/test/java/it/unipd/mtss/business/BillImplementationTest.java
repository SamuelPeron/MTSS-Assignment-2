////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

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

}