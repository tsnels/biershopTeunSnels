package be.vdab.biershopteunsnels.domain;

import java.math.BigDecimal;

public class Bier {

    private final long id;
    private final String naam;
    private final long brouwerId;
    private final BigDecimal alcohol;
    private final BigDecimal prijs;
    private final long besteld;

    public Bier(long id, String naam, long brouwerId, BigDecimal alcohol, BigDecimal prijs, long besteld) {
        this.id = id;
        this.naam = naam;
        this.brouwerId = brouwerId;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    public Bier(String naam, long brouwerId, BigDecimal alcohol, BigDecimal prijs, long besteld) {
        this.id = 0;
        this.naam = naam;
        this.brouwerId = brouwerId;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getBrouwerId() {
        return brouwerId;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getBesteld() {
        return besteld;
    }
}
