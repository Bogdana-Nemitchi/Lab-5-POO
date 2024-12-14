package md.FilmsManagement.FilmsManagement.repository;

import md.FilmsManagement.FilmsManagement.entity.inchirieri;
import md.FilmsManagement.FilmsManagement.entity.clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class inchirieriRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<inchirieri> retrieveAll() {
        return jdbcTemplate.query("SELECT * FROM inchirieri", (row, index) -> {
            int id_inchirieri = row.getInt("id_inchiriere");
            int id_film = row.getInt("id_film");
            int id_client = row.getInt("id_client");
            int data_inchirieri = row.getInt("data_inchiriere");

            return new inchirieri(id_inchirieri, id_film, id_client, data_inchirieri);
        });
    }

    public inchirieri retrieveById(int id_inchirieri) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM inchirieri WHERE id_inchirieri = ?",
                (row, index) -> {
                    int idInchirieri = row.getInt("id_inchiriere");
                    int id_film = row.getInt("id_film");
                    int id_client = row.getInt("id_client");
                    int data_inchirieri = row.getInt("data_inchiriere");

                    return new inchirieri(id_inchirieri, id_film, id_client, data_inchirieri);
                },
                id_inchirieri);
    }

    public void create(inchirieri rental) {
        jdbcTemplate.update(
                "INSERT INTO inchirieri (id_inchirieri, id_film, id_client, data_inchirieri) VALUES (?, ?, ?, ?)",
                rental.getId_inchirieri(), rental.getId_film(), rental.getId_client(), rental.getData_inchirieri());
    }

    public void update(int id_inchirieri, inchirieri rental) {
        jdbcTemplate.update(
                "UPDATE inchirieri SET id_film = ?, id_client = ?, data_inchirieri = ? WHERE id_inchirieri = ?",
                rental.getId_film(), rental.getId_client(), rental.getData_inchirieri(), id_inchirieri);
    }

    public void delete(int id_inchirieri) {
        jdbcTemplate.update("DELETE FROM inchirieri WHERE id_inchirieri = ?", id_inchirieri);
    }

    public List<clienti> retrieveClientiByFilmId(int id_film) {
        return jdbcTemplate.query(
                "SELECT c.id_client, c.nume, c.email, c.telefon FROM clienti c " +
                        "INNER JOIN inchirieri i ON c.id_client = i.id_client " +
                        "WHERE i.id_film = ?",
                (row, index) -> {
                    int id_client = row.getInt("id_client");
                    String nume = row.getString("nume");
                    String email = row.getString("email");
                    String telefon = row.getString("telefon");

                    return new clienti(id_client, nume, email, telefon);
                },
                id_film);
    }
}
