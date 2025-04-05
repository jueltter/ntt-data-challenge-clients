package ec.dev.samagua.ntt_data_challenge_clients.controllers_models;

import ec.dev.samagua.ntt_data_challenge_clients.exceptions.RepositoryException;
import ec.dev.samagua.ntt_data_challenge_clients.services_models.ServiceResultError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControllerResult<E> {
    private String status;
    private E data;
    private ControllerResultError error;

    public static <E> ControllerResult<E> getSuccessResult(E data) {
        return ControllerResult.<E>builder()
                .status("success")
                .data(data)
                .build();
    }


    public static <E> ControllerResult<E> getErrorResultFromRepositoryException(RepositoryException exception) {
        List<ControllerResultErrorDetail> details = exception.getDetails().stream().map(detail -> ControllerResultErrorDetail.builder()
                        .code(detail.getCode())
                        .message(detail.getMessage())
                        .build())
                .toList();

        ControllerResultError error = ControllerResultError.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .details(details)
                .build();

        return ControllerResult.<E>builder()
                .status("error")
                .error(error)
                .build();
    }

    public static <E> ControllerResult<E> getErrorResult(String code, String message, List<ServiceResultError> serviceErrors) {
        List<ControllerResultErrorDetail> details = serviceErrors != null ? serviceErrors.stream().map(error -> ControllerResultErrorDetail.builder()
                        .code(error.getCode())
                        .message(error.getMessage())
                        .field(error.getField())
                        .value(error.getValue())
                        .build())
                .toList() : null;

        ControllerResultError error = ControllerResultError.builder()
                .code(code)
                .message(message)
                .details(details)
                .build();

        return ControllerResult.<E>builder()
                .status("error")
                .error(error)
                .build();
    }
}
