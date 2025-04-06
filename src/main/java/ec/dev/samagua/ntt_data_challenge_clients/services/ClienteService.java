package ec.dev.samagua.ntt_data_challenge_clients.services;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClienteService {
    Mono<Cliente> create(Cliente cliente);
    Mono<Cliente> update(Cliente cliente);
    Mono<Cliente> updatePatch(Cliente cliente);
    Mono<Void> delete(Cliente cliente);
    Mono<Cliente> findById(Long id);
    Mono<List<Cliente>> findAll();
}
