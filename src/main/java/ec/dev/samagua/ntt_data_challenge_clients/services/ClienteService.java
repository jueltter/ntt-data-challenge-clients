package ec.dev.samagua.ntt_data_challenge_clients.services;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClienteService {
    Mono<Cliente> create(Cliente cliente);
    Mono<Cliente> update(Long id, Cliente newData);
    Mono<Cliente> updatePatch(Long id, Cliente newData);
    Mono<Void> delete(Long id);
    Mono<Cliente> findById(Long id);
    Mono<List<Cliente>> findAll();
}
