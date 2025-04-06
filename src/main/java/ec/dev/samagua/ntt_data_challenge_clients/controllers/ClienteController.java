package ec.dev.samagua.ntt_data_challenge_clients.controllers;

import ec.dev.samagua.ntt_data_challenge_clients.controllers_models.ControllerResult;
import ec.dev.samagua.ntt_data_challenge_clients.dtos.ClienteDto;
import ec.dev.samagua.ntt_data_challenge_clients.dtos_mappers.ClienteDtoMapper;
import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.services.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService service;
    private final ClienteDtoMapper mapper; // ignore

    @GetMapping("/clientes")
    public Mono<ResponseEntity<ControllerResult<List<ClienteDto>>>> findAll() {
        log.debug("executing GET /clientes");
        Mono<List<Cliente>> entities = service.findAll();
        return entities.map(obj -> {
            ControllerResult<List<ClienteDto>> body = ControllerResult.getSuccessResult(obj.stream()
                    .map(mapper::entityToDtoObfuscated)
                    .toList());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        });
    }

    @PostMapping("/clientes")
    public Mono<ResponseEntity<ControllerResult<ClienteDto>>> create(@RequestBody ClienteDto dto) {
        Cliente entity = mapper.dtoToEntity(dto);
        log.debug("executing POST /clientes, body: {}", dto);
        log.debug("executing POST /clientes, bodyToEntity: {}", entity);

        Mono<Cliente> entityAsMono = service.create(entity);
        return entityAsMono.map(obj -> {
            ControllerResult<ClienteDto> body = ControllerResult.getSuccessResult(mapper.entityToDto(obj));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        });
    }


}
