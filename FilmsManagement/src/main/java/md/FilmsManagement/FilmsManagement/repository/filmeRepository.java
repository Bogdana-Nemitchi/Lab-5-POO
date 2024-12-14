package md.FilmsManagement.FilmsManagement.repository;

import md.FilmsManagement.FilmsManagement.entity.filme;
import md.FilmsManagement.FilmsManagement.entity.clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class filmeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<filme> retrieveAll() {
        return jdbcTemplate.query("SELECT * FROM Filme", (row, index) -> {
            int id_film = row.getInt("id_film");
            String titlu = row.getString("titlu");
            int an_lansare = row.getInt("an_lansare");

            return new filme(id_film, titlu, an_lansare);
        });
    }

    public filme retrieveById(int id_filme) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Filme WHERE id_film = ?",
                (row, index) -> {
                    int id_film = row.getInt("id_film");
                    String titlu = row.getString("titlu");
                    int an_lansare = row.getInt("an_lansare");

                    return new filme(id_film, titlu, an_lansare);
                },
                id_filme);
    }

    public void create(filme film) {
        jdbcTemplate.update(
                "INSERT INTO Filme (id_film, titlu, an_lansare) VALUES (?, ?, ?)",
                film.getId_film(), film.getTitlu(), film.getAn_lansare());
    }

    public void update(int id_film, filme film) {
        jdbcTemplate.update(
                "UPDATE Filme SET titlu = ?, an_lansare = ? WHERE id_film = ?",
                film.getTitlu(), film.getAn_lansare(), id_film);
    }

    public void delete(int id_film) {
        jdbcTemplate.update("DELETE FROM Filme WHERE id_film = ?", id_film);
    }

    public List<clienti> retrieveClientiByFilmId(int id_filme) {
        return jdbcTemplate.query(
                "SELECT c.id_client, c.nume, c.email FROM clienti c " +
                        "INNER JOIN filme f ON c.id_client = f.id_client " +
                        "WHERE f.id_film = ?",
                (row, index) -> {
                    int id_client = row.getInt("id_client");
                    String nume = row.getString("nume");
                    String email = row.getString("email");
                    String telefon = row.getString("telefon");

                    return new clienti(id_client, nume, email, telefon);
                },
                id_filme);
    }
}
