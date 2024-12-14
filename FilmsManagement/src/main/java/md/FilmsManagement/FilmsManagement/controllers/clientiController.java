package md.FilmsManagement.FilmsManagement.controllers;

import md.FilmsManagement.FilmsManagement.entity.clienti;
import md.FilmsManagement.FilmsManagement.repository.clientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clienti")
public class clientiController {

    @Autowired
    private clientiRepository clientiRepository;

    @GetMapping
    public List<clienti> retrieve() {
        return clientiRepository.retrieve();
    }

    @GetMapping("{id_client}")
    public clienti retrieveById(@PathVariable int id_client) {
        return clientiRepository.retrieveById_clienti(id_client);
    }

    @GetMapping("greaterThan")
    public List<clienti> retrieveClientiGreaterThan(@RequestParam("id_client") int id_client) {
        return clientiRepository.retrieveClientiGreaterThan(id_client);
    }

    @PostMapping
    public void create(@RequestBody clienti client) {
        clientiRepository.create(client);
    }

    @PutMapping("{id_client}")
    public void update(@PathVariable int id_client, @RequestBody clienti client) {
        clientiRepository.update(id_client, client);
    }

    @DeleteMapping("{id_client}")
    public void delete(@PathVariable int id_client) {
        clientiRepository.delete(id_client);
    }
}
