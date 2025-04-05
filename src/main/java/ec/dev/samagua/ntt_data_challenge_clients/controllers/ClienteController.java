package ec.dev.samagua.ntt_data_challenge_clients.controllers;

import ec.dev.samagua.ntt_data_challenge_clients.controllers_models.ControllerResult;
import ec.dev.samagua.ntt_data_challenge_clients.dtos.ClienteDto;
import ec.dev.samagua.ntt_data_challenge_clients.dtos_mappers.ClienteDtoMapper;
import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.services.ClienteService;
import ec.dev.samagua.ntt_data_challenge_clients.services_models.ServiceResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService service;
    private final ClienteDtoMapper mapper;

    @GetMapping("/clientes")
    public Mono<ControllerResult<List<ClienteDto>>> findAll() {
        Mono<ServiceResult<List<Cliente>>> entities = service.findAll();
        return entities.map(obj -> {
            if (obj.hasErrors()) {
                return ControllerResult.getErrorResult("1234", "An error has occurred while searching clients", obj.getErrors());
            }
            return ControllerResult.getSuccessResult(obj.getValue().stream().map(mapper::entityToDtoObfuscated).toList());
        });
    }


}
