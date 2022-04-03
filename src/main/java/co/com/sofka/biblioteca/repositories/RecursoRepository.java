package co.com.sofka.biblioteca.repositories;

import co.com.sofka.biblioteca.models.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecursoRepository extends ReactiveMongoRepository<Recurso, String> {

}
