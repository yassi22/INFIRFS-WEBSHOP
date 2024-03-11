package com.example.codealongw3.dto;

public class UserDTO {

    public String email;
    public String password;

    public String voornaam;

    public String tussenvoegsel;

    public String achternaam;

    public String straat;

    public int huisnummer;

    public String postcode;

    public UserDTO(String email, String password, String voornaam, String tussenvoegsel, String achternaam, String straat, int huisnummer, String postcode) {
        this.email = email;
        this.password = password;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
    }


}
