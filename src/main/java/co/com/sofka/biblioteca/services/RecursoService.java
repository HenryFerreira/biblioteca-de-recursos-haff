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

    /*Consultar disponibilidad de un recurso indicando en un mensaje si esta disponible o no.
    en caso de no estar disponible presentar la fecha del préstamo actual del ultimo ejemplar.*/
    Mono<String> disponibilidadById(String id);


}
