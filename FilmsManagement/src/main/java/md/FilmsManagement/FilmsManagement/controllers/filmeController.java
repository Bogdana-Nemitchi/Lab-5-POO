package md.FilmsManagement.FilmsManagement.controllers;

import md.FilmsManagement.FilmsManagement.entity.filme;
import md.FilmsManagement.FilmsManagement.entity.clienti;
import md.FilmsManagement.FilmsManagement.repository.filmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filme")
public class filmeController {

    @Autowired
    private filmeRepository filmeRepository;

    @GetMapping
    public List<filme> retrieveAll() {
        return filmeRepository.retrieveAll();
    }

    @GetMapping("{id_film}")
    public filme retrieveById(@PathVariable int id_film) {  // Am schimbat din String în int
        return filmeRepository.retrieveById(id_film);
    }

    @PostMapping
    public void create(@RequestBody filme film) {
        filmeRepository.create(film);
    }

    @PutMapping("{id_film}")
    public void update(@PathVariable int id_film, @RequestBody filme film) {
        filmeRepository.update(id_film, film);
    }

    @DeleteMapping("{id_film}")
    public void delete(@PathVariable int id_film) {
        filmeRepository.delete(id_film);
    }

    @GetMapping("{id_film}/clienti")
    public List<clienti> retrieveClientiByFilmId(@PathVariable int id_film) {
        return filmeRepository.retrieveClientiByFilmId(id_film);
    }
}
