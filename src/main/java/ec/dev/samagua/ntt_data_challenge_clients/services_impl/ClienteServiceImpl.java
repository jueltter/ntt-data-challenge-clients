package ec.dev.samagua.ntt_data_challenge_clients.services_impl;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.repositories.ClienteRepository;
import ec.dev.samagua.ntt_data_challenge_clients.services.ClienteService;
import ec.dev.samagua.ntt_data_challenge_clients.services_models.ServiceResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;


    @Override
    public Mono<ServiceResult<Cliente>> create(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ServiceResult<Cliente>> update(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ServiceResult<Cliente>> updatePatch(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ServiceResult<Void>> delete(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ServiceResult<Cliente>> findById(Long id) {
        return null;
    }

    @Override
    public Mono<ServiceResult<List<Cliente>>> findAll() {
       Mono<List<Cliente>> entities = repository.findAll();
       return entities.map(obj -> new ServiceResult<>(obj, null));
    }
}
