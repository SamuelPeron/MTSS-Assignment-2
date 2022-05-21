////////////////////////////////////////////////////////////////////
// [Mattia] [Brunello] [2009096]
// [Samuel] [Peron] [1225423]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

public class User {

    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;

    public User(String nome, String cognome, LocalDate datanascita, String email) {
        name = nome;
        surname = cognome;
        dateOfBirth = datanascita;
        this.email = email;
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("La data di nascita è null");
        }
        if (dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth = datanascita;
        } else {
            throw new IllegalArgumentException("La data di nascita deve essere precedente alla data odierna");
        }

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
