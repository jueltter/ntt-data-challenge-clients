package ec.dev.samagua.ntt_data_challenge_clients.repositories;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.utils_exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClienteRepository {

    private final ClienteReactiveRepository repository;

    public Mono<Long> countByClienteId(String clienteId) {
        return repository.countByClienteId(clienteId)
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(error -> log.error("Error counting clients by client ID", error));
    }

    public Mono<Long> countByIdentificacion(String identificacion) {
        return repository.countByIdentificacion(identificacion)
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(error -> log.error("Error counting clients by identification", error));
    }

    public Mono<List<Cliente>> findByClienteId(String clienteId) {
        return repository.findByClienteId(clienteId)
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(error -> log.error("Error finding client by client ID", error))
                .map(List::of);
    }

    public Mono<Cliente> save(Cliente cliente) {
        return repository.save(cliente)
                .onErrorMap(RepositoryException::getCreateException)
                .doOnError(error -> log.error("Error creating client", error));
    }

    public Mono<Cliente> update(Cliente cliente) {
        return repository.save(cliente)
                .onErrorMap(RepositoryException::getUpdateException)
                .doOnError(error -> log.error("Error updating client", error));
    }

    public Mono<Void> delete(Cliente cliente) {
        return repository.delete(cliente)
                .onErrorMap(RepositoryException::getDeleteException)
                .doOnError(error -> log.error("Error deleting client", error));
    }

    public Mono<Cliente> findById(Long id) {
        return repository.findById(id)
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(error -> log.error("Error finding client", error))
                .defaultIfEmpty(Cliente.getDefaultInstance());
    }

    public Mono<List<Cliente>> findAll() {
        return repository.findAll()
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(error -> log.error("Error finding all clients", error))
                .collectList();
    }
}
