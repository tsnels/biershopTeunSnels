package be.vdab.biershopteunsnels.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;


public class MandjeItems {

    private final String naam;
    private final BigDecimal prijs;
    private final int aantal;

    public MandjeItems(String naam, BigDecimal prijs, int aantal) {
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getTotaal() {
        return prijs.multiply(BigDecimal.valueOf(aantal));
    }
}