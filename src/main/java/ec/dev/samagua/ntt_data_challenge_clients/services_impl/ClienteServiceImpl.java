package ec.dev.samagua.ntt_data_challenge_clients.services_impl;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.exceptions.InvalidDataException;
import ec.dev.samagua.ntt_data_challenge_clients.repositories.ClienteRepository;
import ec.dev.samagua.ntt_data_challenge_clients.services.ClienteService;
import ec.dev.samagua.ntt_data_challenge_clients.utils.EncryptDecryptUtils;
import ec.dev.samagua.ntt_data_challenge_clients.utils_data.DataValidationResult;
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
    public Mono<Cliente> create(Cliente cliente) {
        Mono<Long> countIdentificacion = repository.countByIdentificacion(cliente.getIdentificacion());
        Mono<Long> countClienteId = repository.countByClienteId(cliente.getClienteId());

        return Mono.zip(countIdentificacion, countClienteId).flatMap(tuple -> {
                    Long countIdentificacionAsLong = tuple.getT1();
                    Long countClienteIdAsLong = tuple.getT2();

                    DataValidationResult clientValidationResult = cliente.validateForCreation(countIdentificacionAsLong, countClienteIdAsLong);

                    if (!clientValidationResult.isValid()) {
                        return Mono.error(InvalidDataException.getInstance(clientValidationResult.getErrors()));
                    }

                    String claveAsMD5 = EncryptDecryptUtils.md5(cliente.getClave());
                    cliente.setClave(claveAsMD5);

                    return Mono.empty();
                })
                .then(repository.save(cliente));
    }

    @Override
    public Mono<Cliente> update(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<Cliente> updatePatch(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<Void> delete(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<Cliente> findById(Long id) {
        return null;
    }

    @Override
    public Mono<List<Cliente>> findAll() {
       return repository.findAll();
    }
}
