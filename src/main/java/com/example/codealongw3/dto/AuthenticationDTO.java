package com.example.codealongw3.dto;

import org.springframework.lang.Nullable;

public class AuthenticationDTO {
    public String email;
    public String password;

    public String voornaam;

    @Nullable
    public String tussenvoegsel;

    public String achternaam;

    public String straat;

    public int huisnummer;

    public String postcode;


    public AuthenticationDTO(String email, String password, String voornaam, String tussenvoegsel, String achternaam, String straat, int huisnummer, String postcode) {
        this.email = email;
        this.password = password;
        this.tussenvoegsel = tussenvoegsel;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
    }



}
