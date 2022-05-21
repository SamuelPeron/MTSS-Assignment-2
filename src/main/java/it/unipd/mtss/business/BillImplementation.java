////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public class BillImplementation implements Bill {

    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        HashMap<EItem.itemType, ArrayList<EItem>> map = new HashMap<EItem.itemType, ArrayList<EItem>>();

        for (EItem x : itemsOrdered) {
            if (map.get(x.getType()) == null) {
                ArrayList<EItem> l = new ArrayList<EItem>();
                l.add(x);
                map.put(x.getType(), l);
            } else {
                map.get(x.getType()).add(x);
            }
        }

        return getMouseKeyboardPrice(map.get(EItem.itemType.MOUSE), map.get(EItem.itemType.KEYBOARD)) +
                getProcessorsPrice(map.get(EItem.itemType.PROCESSOR)) +
                getMotherboardPrice(map.get(EItem.itemType.MOTHERBOARD));
    }

    double getProcessorsPrice(List<EItem> processList) {
        if (processList == null || processList.size() == 0) {
            return 0.0;
        }

        if (processList.size() > 5) {
            processList.stream().min(Comparator.comparing((EItem x) -> x.getPrice())).get().discount(0.5);
        }

        return processList.stream().map((x) -> x.getPrice()).reduce(0.0, (a, b) -> a + b);
    }

    double getMotherboardPrice(List<EItem> motherboardList) {
        if (motherboardList == null || motherboardList.size() == 0) {
            return 0.0;
        }
        return motherboardList.stream().map((x) -> x.getPrice()).reduce(0.0, (a, b) -> a + b);
    }

    double getMouseKeyboardPrice(List<EItem> mouseList, List<EItem> keyboardList) {

        ArrayList<EItem> all = new ArrayList<EItem>();
        if (mouseList != null) {
            all.addAll(mouseList);
            if (mouseList.size() > 5) {
                mouseList.stream().min(Comparator.comparing((EItem x) -> x.getPrice())).get().discount(0.5);
            }
        }

        if (keyboardList != null) {
            all.addAll(keyboardList);
            if (mouseList != null && mouseList.size() != 0 && mouseList.size() == keyboardList.size()) {
                all.stream().min(Comparator.comparing((EItem x) -> x.getPrice())).get().discount(1.0);
            }
        }

        return all.stream().map((x) -> x.getPrice()).reduce(0.0, (a, b) -> a + b);
    }
}