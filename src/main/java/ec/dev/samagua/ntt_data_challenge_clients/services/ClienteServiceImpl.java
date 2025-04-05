package ec.dev.samagua.ntt_data_challenge_clients.services;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.services_utils.ServiceResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


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
    public Mono<ServiceResult<Cliente>> delete(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ServiceResult<Cliente>> findById(Long id) {
        return null;
    }

    @Override
    public Mono<ServiceResult<List<Cliente>>> findAll() {
        return null;
    }
}
