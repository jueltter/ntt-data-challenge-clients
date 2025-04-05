package ec.dev.samagua.ntt_data_challenge_clients.controllers_exception_handler;

import ec.dev.samagua.ntt_data_challenge_clients.controllers_models.ControllerResult;
import ec.dev.samagua.ntt_data_challenge_clients.exceptions.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ControllersErrorHandler {

    @ExceptionHandler(RepositoryException.class)
    public Mono<ResponseEntity<ControllerResult<Void>>> handleRepositoryException(RepositoryException ex) {
        ControllerResult<Void> body = ControllerResult.getErrorResultFromRepositoryException(ex);

        return Mono.just(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ControllerResult<Void>>> handleGeneric(Exception ex) {
        ControllerResult<Void> body = ControllerResult.getErrorResult(ex.getClass().getCanonicalName(),  ex.getMessage(), null);

        return Mono.just(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body));
    }

}
