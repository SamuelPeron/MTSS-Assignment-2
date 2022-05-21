////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Extraction {
    Random rnd;
    List<User> users;

    public Extraction() {
        rnd = new Random(10121815);
        users = new ArrayList<>();
    }

    public boolean extractionControl(User user, LocalTime timeStamp) {
        if (Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18) {
            if (users.size() < 10) {
                if (timeStamp.isAfter(LocalTime.of(18, 0)) && timeStamp.isBefore(LocalTime.of(19, 0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean extract(User user, LocalTime timeStamp) {

        if (user == null) {
            throw new IllegalArgumentException("User missing");
        }
        if (timeStamp == null) {
            throw new IllegalArgumentException("Timestamp missing");
        }

        if (extractionControl(user, timeStamp) && rnd.nextInt(100) <= 25) {
            users.add(user);
            return true;
        }
        return false;
    }
}