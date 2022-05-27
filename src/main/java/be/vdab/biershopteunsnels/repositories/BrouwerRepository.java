package be.vdab.biershopteunsnels.repositories;


import be.vdab.biershopteunsnels.domain.Brouwer;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BrouwerRepository {

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Brouwer> brouwerMapper = (result, rowNum) ->
            new Brouwer(result.getLong("id"), result.getString("naam"),
                    result.getString("straat"), result.getString("huisNr"),
                    result.getInt("postcode"), result.getString("gemeente"),
                    result.getBigDecimal("omzet"));

    public BrouwerRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template).withTableName("brouwers").usingGeneratedKeyColumns("id");
    }

    public List<Brouwer> findAll() {
        var sql = """
                    select id, naam, straat, huisNr, postcode, gemeente, omzet
                    from brouwers
                """;
        return template.query(sql, brouwerMapper);
    }

    public Optional<Brouwer> findById(long id) {
        try {
            var sql = """
                    select id, naam, straat, huisNr, postcode, gemeente, omzet
                    from brouwers
                    where id = ?
                """;
        return Optional.of(template.queryForObject(sql, brouwerMapper, id));
    } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

}