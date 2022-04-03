package co.com.sofka.biblioteca.services;

import co.com.sofka.biblioteca.models.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoService {
    //----------------------------------------------//
    //CRUD
    Mono<Recurso> save(Recurso cliente);

    Mono<Recurso> delete(String id);

    Mono<Recurso> update(String id, Recurso cliente);

    Flux<Recurso> findAll();

    Mono<Recurso> findById(String id);
    //----------------------------------------------//



}
