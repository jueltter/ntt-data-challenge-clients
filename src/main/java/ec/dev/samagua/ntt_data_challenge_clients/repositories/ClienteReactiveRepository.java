package ec.dev.samagua.ntt_data_challenge_clients.repositories;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClienteReactiveRepository extends ReactiveCrudRepository<Cliente, Long> {

    Mono<Cliente> findByClienteId(String clienteId);

    Mono<Long> countByClienteId(String clienteId);

    Mono<Long> countByIdentificacion(String identificacion);

}
