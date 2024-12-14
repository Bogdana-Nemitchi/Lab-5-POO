package md.FilmsManagement.FilmsManagement.controllers;

import md.FilmsManagement.FilmsManagement.entity.inchirieri;
import md.FilmsManagement.FilmsManagement.entity.clienti;
import md.FilmsManagement.FilmsManagement.repository.inchirieriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inchirieri")
public class inchirieriController {

    @Autowired
    private inchirieriRepository inchirieriRepository;

    @GetMapping
    public List<inchirieri> retrieveAll() {
        return inchirieriRepository.retrieveAll();
    }

    @GetMapping("{id_inchirieri}")
    public inchirieri retrieveById(@PathVariable int id_inchirieri) {
        return inchirieriRepository.retrieveById(id_inchirieri);
    }

    @PostMapping
    public void create(@RequestBody inchirieri rental) {
        inchirieriRepository.create(rental);
    }

    @PutMapping("{id_inchirieri}")
    public void update(@PathVariable int id_inchirieri, @RequestBody inchirieri rental) {
        inchirieriRepository.update(id_inchirieri, rental);
    }

    @DeleteMapping("{id_inchirieri}")
    public void delete(@PathVariable int id_inchirieri) {
        inchirieriRepository.delete(id_inchirieri);
    }

    @GetMapping("film/{id_film}/clienti")
    public List<clienti> retrieveClientiByFilmId(@PathVariable int id_film) {
        return inchirieriRepository.retrieveClientiByFilmId(id_film);
    }
}
