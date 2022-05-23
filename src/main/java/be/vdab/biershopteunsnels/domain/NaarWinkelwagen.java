package be.vdab.biershopteunsnels.domain;

public class NaarWinkelwagen {

    private final String naam;
    private final String straat;
    private final String huisnummer;
    private final int postcode;
    private final String gemeente;

    public NaarWinkelwagen(String naam, String straat, String huisnummer, int postcode, String gemeente) {
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}