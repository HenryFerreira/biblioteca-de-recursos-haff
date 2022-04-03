package co.com.sofka.biblioteca.controllers;

import co.com.sofka.biblioteca.models.Recurso;
import co.com.sofka.biblioteca.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RecursoController {
    @Autowired
    private RecursoService service;

    //----------------------------------------------//
    //CRUD
    @PostMapping("/recurso")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Recurso> save(@RequestBody Recurso recurso) {
        return this.service.save(recurso);
    }

    @DeleteMapping("/recurso/{id}")
    private Mono<Recurso> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(recurso -> Mono.just((recurso)))
                .switchIfEmpty(Mono.empty());
    }

    @PutMapping("/recurso/{id}")
    private Mono<Recurso> update(@PathVariable("id") String id, @RequestBody Recurso recurso) {
        return this.service.update(id, recurso)
                .flatMap(recurso1 -> Mono.just((recurso1)))
                .switchIfEmpty(Mono.empty());

    }

    @GetMapping(value = "/recurso")
    private Flux<Recurso> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/recurso/{id}/findById")
    private Mono<Recurso> findByid(@PathVariable("id") String id) {
        return this.service.findById(id);
    }
    //----------------------------------------------//

    @GetMapping("/recurso/{id}/disponibilidad")
    private Mono<String> disponibilidadById(@PathVariable("id") String id) {
        return this.service.disponibilidadById(id);
    }

}
