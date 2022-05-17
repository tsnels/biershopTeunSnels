package be.vdab.biershopteunsnels.domain;

import java.math.BigDecimal;

public class Brouwer {

    private final long id;
    private final String naam;
    private final String straat;
    private final String nummer;
    private final int postcode;
    private final String gemeente;
    private final BigDecimal omzet;

    public Brouwer(long id, String naam, String straat, String nummer, int postcode, String gemeente, BigDecimal omzet) {
        this.id = id;
        this.naam = naam;
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getNummer() {
        return nummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public BigDecimal getOmzet() {
        return omzet;
    }
}
