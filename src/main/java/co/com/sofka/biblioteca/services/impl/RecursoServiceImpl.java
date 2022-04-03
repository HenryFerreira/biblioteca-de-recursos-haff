package co.com.sofka.biblioteca.services.impl;

import co.com.sofka.biblioteca.models.Recurso;
import co.com.sofka.biblioteca.repositories.RecursoRepository;
import co.com.sofka.biblioteca.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecursoServiceImpl implements RecursoService {
    @Autowired
    private RecursoRepository repository;

    //----------------------------------------------//
    //CRUD
    @Override
    public Mono<Recurso> save(Recurso recurso) {
        return this.repository.save(recurso);
    }

    @Override
    public Mono<Recurso> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<Recurso> update(String id, Recurso recurso) {
        return this.repository.findById(id)
                .flatMap(recurso1 -> {
                    recurso.setId(id);
                    return save(recurso);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Recurso> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Recurso> findById(String id) {
        return this.repository.findById(id);
    }
    //----------------------------------------------//
}
