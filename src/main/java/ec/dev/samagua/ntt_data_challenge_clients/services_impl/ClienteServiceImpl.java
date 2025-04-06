package ec.dev.samagua.ntt_data_challenge_clients.services_impl;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.exceptions.InvalidDataException;
import ec.dev.samagua.ntt_data_challenge_clients.repositories.ClienteRepository;
import ec.dev.samagua.ntt_data_challenge_clients.services.ClienteService;
import ec.dev.samagua.ntt_data_challenge_clients.utils.EncryptDecryptUtils;
import ec.dev.samagua.ntt_data_challenge_clients.utils_data.DataValidationResult;
import ec.dev.samagua.ntt_data_challenge_clients.utils_data.IdentityFieldWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.reactive.PreFlightRequestHandler;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final PreFlightRequestHandler preFlightRequestHandler;

    @Override
    public Mono<Cliente> create(Cliente cliente) {
        Mono<Long> countIdentificacion = repository.countByIdentificacion(cliente.getIdentificacion());
        Mono<Long> countClienteId = repository.countByClienteId(cliente.getClienteId());

        return Mono.zip(countIdentificacion, countClienteId).flatMap(tuple -> {
                    Long countIdentificacionAsLong = tuple.getT1();
                    Long countClienteIdAsLong = tuple.getT2();

                    DataValidationResult clientValidationResult = cliente.validateForCreating(countIdentificacionAsLong, countClienteIdAsLong);

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
    public Mono<Cliente> update(Long id, Cliente newData) {
        Mono<Cliente> entityMono = repository.findById(id);
        Mono<Long> countIdentificacionMono = repository.countByIdentificacion(newData.getIdentificacion());
        Mono<Long> countClienteIdMono = repository.countByClienteId(newData.getClienteId());

        return Mono.zip(countIdentificacionMono, countClienteIdMono, entityMono)
                .flatMap(tuple -> {
                    Cliente entity = tuple.getT3();

                    if (!entity.isValidId()) {
                        return Mono.error(InvalidDataException.getInstance(Collections.singletonMap("id", "is invalid")));
                    }

                    Long countIdentificacion = tuple.getT1();
                    IdentityFieldWrapper identificacionWrapper = new IdentityFieldWrapper(countIdentificacion, Objects.equals(entity.getIdentificacion(), newData.getIdentificacion()));
                    Long countClienteId = tuple.getT2();
                    IdentityFieldWrapper clienteIdWrapper = new IdentityFieldWrapper(countClienteId, Objects.equals(entity.getClienteId(), newData.getClienteId()));

                    DataValidationResult clientValidationResult = newData.validateForUpdating(identificacionWrapper, clienteIdWrapper);

                    if (!clientValidationResult.isValid()) {
                        return Mono.error(InvalidDataException.getInstance(clientValidationResult.getErrors()));
                    }

                    String claveAsMD5 = EncryptDecryptUtils.md5(newData.getClave());
                    newData.setClave(claveAsMD5);
                    newData.setId(id);

                    BeanUtils.copyProperties(newData, entity);

                    return repository.save(entity);
                });
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
