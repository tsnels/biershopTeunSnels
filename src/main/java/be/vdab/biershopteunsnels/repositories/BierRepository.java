package be.vdab.biershopteunsnels.repositories;


import be.vdab.biershopteunsnels.domain.Bier;
import be.vdab.biershopteunsnels.domain.Brouwer;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class BierRepository {

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Bier> bierMapper = (result, rowNum) ->
            new Bier(result.getLong("id"), result.getString("naam"),
                    result.getLong("brouwerId"), result.getBigDecimal("alcohol"),
                    result.getBigDecimal("prijs"), result.getLong("besteld"));
//    private final RowMapper<BigDecimal> prijsMapper =
//            (result, rowNum) -> result.getBigDecimal("prijs");

    public BierRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template).withTableName("bieren").usingGeneratedKeyColumns("id");
    }

    public long findAantal() {
        var sql = """
                    select count(*)
                    from bieren
                """;
        return template.queryForObject(sql, Long.class);
    }

    public List<Bier> findByBrouwerId(long id) {
        var sql = """
                select id, naam, brouwerId, alcohol, prijs, besteld
                from bieren
                where BrouwerId = ?
            """;
        return template.query(sql, bierMapper, id);
    }

    public Optional<Bier> findByBierId(long id) {
        try {
            var sql = """
                    select id, naam, brouwerId, alcohol, prijs, besteld
                    from bieren
                    where id = ?
                """;
            return Optional.of(template.queryForObject(sql, bierMapper, id));
    } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }


}
