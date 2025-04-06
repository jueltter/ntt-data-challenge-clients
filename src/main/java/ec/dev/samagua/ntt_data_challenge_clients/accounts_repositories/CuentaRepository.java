package ec.dev.samagua.ntt_data_challenge_clients.accounts_repositories;


import ec.dev.samagua.ntt_data_challenge_clients.accounts_models.Cuenta;
import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.utils_controllers_models.ControllerResult;
import ec.dev.samagua.ntt_data_challenge_clients.utils_exceptions.RepositoryException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CuentaRepository {
    private final WebClient webClient;

    public Mono<List<Cuenta>> findByClienteId(String clienteId) {
        return webClient.get()
                .uri("/cuentas?cliente-id={clienteId}", clienteId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ControllerResult<List<Cuenta>>>() {})
                .onErrorMap(RepositoryException::getReadException)
                .doOnError(e -> log.error("Error fetching accounts", e))
                .map(ControllerResult::getData);
    }
}
