package be.vdab.biershopteunsnels.repositories;


import be.vdab.biershopteunsnels.domain.MandjeItems;
import be.vdab.biershopteunsnels.forms.PersoonsGegevens;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BestelRepository {

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final SimpleJdbcInsert insert2;


    public BestelRepository(JdbcTemplate template) {
        this.template = template;
        insert = new SimpleJdbcInsert(template).withTableName("bestelbonnen").usingGeneratedKeyColumns("id");
        insert2 = new SimpleJdbcInsert(template).withTableName("bestelbonlijnen").usingGeneratedKeyColumns("id");
    }

    public long createBestelBon(PersoonsGegevens persoonsGegevens) {
        return insert.executeAndReturnKey(
                Map.of("naam", persoonsGegevens.naam(),
                        "straat", persoonsGegevens.straat(),
                        "huisNr", persoonsGegevens.huisNr(),
                        "postcode", persoonsGegevens.postcode(),
                        "gemeente", persoonsGegevens.gemeente())).longValue();
    }

    public void createBestelbonlijnen (MandjeItems item, long bestelbonId) {
        System.out.println(bestelbonId);
        System.out.println(item.getBierId());
        System.out.println(item.getAantal());
        System.out.println(item.getPrijs());
            insert2.execute(
                    Map.of("bestelbonId", bestelbonId,
                            "bierId", item.getBierId(),
                            "aantal", item.getAantal(),
                            "prijs", item.getPrijs()
                            ));
    }
}