package com.cgi.dentistapp.dto;

import javax.validation.constraints.Size;

public class DentistDTO {

    @Size(min = 1, max = 15)
    String firstName;

    @Size(min = 1, max = 35)
    String lastName;

    public DentistDTO() {
    }

    public DentistDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
