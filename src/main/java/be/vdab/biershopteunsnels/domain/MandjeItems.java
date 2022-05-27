package be.vdab.biershopteunsnels.domain;


import java.math.BigDecimal;


public class MandjeItems {

    private final String naam;
    private final BigDecimal prijs;
    private final int aantal;
    private final long bierId;

    public MandjeItems(String naam, BigDecimal prijs, int aantal, long bierId) {
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
        this.bierId = bierId;
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

    public long getBierId() {
        return bierId;
    }

    public BigDecimal getTotaal() {
        return prijs.multiply(BigDecimal.valueOf(aantal));
    }
}