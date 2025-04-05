package ec.dev.samagua.ntt_data_challenge_clients.services;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.services_utils.ServiceResult;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClienteService {
    Mono<ServiceResult<Cliente>> create(Cliente cliente);
    Mono<ServiceResult<Cliente>> update(Cliente cliente);
    Mono<ServiceResult<Cliente>> updatePatch(Cliente cliente);
    Mono<ServiceResult<Cliente>> delete(Cliente cliente);
    Mono<ServiceResult<Cliente>> findById(Long id);
    Mono<ServiceResult<List<Cliente>>> findAll();
}
