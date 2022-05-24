package be.vdab.biershopteunsnels.sessions;

import be.vdab.biershopteunsnels.domain.MandjeItems;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<MandjeItems> items = new ArrayList<>();

    public void voegToe(String naam, BigDecimal prijs, int aantal, long bierId) {
        items.add(new MandjeItems(naam, prijs, aantal, bierId));
    }

    public List<MandjeItems> getItems() {
        return items;
    }

    public BigDecimal getTotaal() {
//        BigDecimal totaal = BigDecimal.ZERO;
//        items.stream().forEach(item -> totaal.add(item.getTotaal()));
        return items.stream().map(item -> item.getTotaal()).reduce(BigDecimal.ZERO, (totaal, prijs) -> totaal.add(prijs));
    }

    public void emptyList() {
        items.clear();
    }
}