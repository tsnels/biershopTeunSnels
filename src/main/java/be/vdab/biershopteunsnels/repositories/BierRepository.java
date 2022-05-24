package be.vdab.biershopteunsnels.repositories;


import be.vdab.biershopteunsnels.domain.Bier;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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

    public List<Bier> findByIds(Set<Long> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        var sql = """
                select id, naam, brouwerId, alcohol, prijs, besteld
                from bieren
                where id in (
                """
                + "?,".repeat(ids.size() -1 )
                + "?) order by id";
        return template.query(sql, bierMapper, ids.toArray());
    }




}
