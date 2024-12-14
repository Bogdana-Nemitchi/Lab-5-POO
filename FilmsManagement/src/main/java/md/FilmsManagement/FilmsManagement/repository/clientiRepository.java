package md.FilmsManagement.FilmsManagement.repository;

import md.FilmsManagement.FilmsManagement.entity.clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class clientiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<clienti> retrieve() {
        return jdbcTemplate.query("SELECT * FROM Clienti",
                (row, index) -> {
                    int id_client = row.getInt("id_client");
                    String nume = row.getString("nume");
                    String email = row.getString("email");
                    String telefon = row.getString("telefon");

                    return new clienti(id_client, nume, email, telefon);
                });
    }

    public clienti retrieveById_clienti(int id_client) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Clienti where id_client = ?",
                (row, index) -> {
                    int idClient = row.getInt("id_client");
                    String nume = row.getString("nume");
                    String email = row.getString("email");
                    String telefon = row.getString("telefon");

                    return new clienti(id_client, nume, email, telefon);
                },
                id_client);
    }

    public void create(clienti clienti) {
        jdbcTemplate.update("insert into clienti(id_client, nume, email, telefon) values(?, ?, ?, ?)",
                clienti.getId_client(), clienti.getNume(), clienti.getEmail(), clienti.getTelefon());
    }

    public void update(int id_client, clienti clienti) {
        jdbcTemplate.update("update clienti set nume = ?, email = ?, telefon = ? where id_client = ?",
                clienti.getNume(), clienti.getEmail(), clienti.getTelefon(), id_client);
    }

    public void delete(int id_client) {
        jdbcTemplate.update("delete from clienti where id_client = ?", id_client);
    }

    public List<clienti> retrieveClientiGreaterThan(int id_client) {
        return jdbcTemplate.query("SELECT * FROM Clienti where id_client > ?",
                (row, index) -> {
                    int idClient = row.getInt("id_client");
                    String nume = row.getString("nume");
                    String email = row.getString("email");
                    String telefon = row.getString("telefon");

                    return new clienti(id_client, nume, email, telefon);
                }, id_client);
    }
}
