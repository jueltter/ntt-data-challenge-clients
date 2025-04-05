package ec.dev.samagua.ntt_data_challenge_clients.repositories;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.reactive_repositories.ClienteReactiveRepository;
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

    public Mono<Cliente> save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Mono<Void> delete(Cliente cliente) {
        return repository.delete(cliente);
    }

    public Mono<Cliente> findById(Long id) {

        return repository.findById(id);
    }

    public Mono<List<Cliente>> findAll() {
        return repository.findAll().collectList();
    }
}
