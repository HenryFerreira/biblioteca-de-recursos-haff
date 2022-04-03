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

    /*Prestar un recurso, se debe comprobar si esta prestado o no, indicarlo mediante un mensaje.
    Si se encuentra disponible debemos marcarlo como prestado y registrar la fecha del préstamo
    (no es necesario llevar el historia de prestamos).*/
    Mono<String> perstarRecursoById(String id);

    /*Recomendar un listado de recursos al usuario a partir del tipo de recurso, del área temática o de los dos.
    Los recursos están clasificados por tipo de recurso (libros, revistas, fichas, etc)
    pero también por área temática (ciencias, naturaleza, historia, etc).*/
    Flux<Recurso> recomendarRecursosByTipo(String tipo);
    Flux<Recurso> recomendarRecursosByCategoria(String categoria);
    Flux<Recurso> recomendarRecursosByCategoriaAndTipo(String categoria, String tipo);

    /*Devolver un recurso que se encontraba prestado,
    obviamente si un recurso no se encuentra en préstamo no podrá ser devuelto.
    Indicar el resultado con un mensaje.*/
    Mono<String> devolverRecursoById(String id);

}
