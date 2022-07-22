package entity;

import exception.HolderException;

public class Holder {

    private String firstName;

    private String lastName;

    public Holder(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new HolderException("First Name and/or Last Name must be not null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

}
