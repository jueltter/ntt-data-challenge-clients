package ec.dev.samagua.ntt_data_challenge_clients.utils_controllers_models;

import ec.dev.samagua.ntt_data_challenge_clients.utils_exceptions.InvalidDataException;
import ec.dev.samagua.ntt_data_challenge_clients.utils_exceptions.RepositoryException;
import ec.dev.samagua.ntt_data_challenge_clients.utils_models.KeyValuePair;
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

    public static ControllerResult<Void> getSuccessResult() {
        return ControllerResult.<Void>builder()
                .status("success")
                .build();
    }

    public static ControllerResult<Void> getErrorResultFromInvalidDataException(InvalidDataException exception) {
        List<ControllerResultErrorDetail> details = exception.getErrors().entrySet().stream().map(entry -> ControllerResultErrorDetail.builder()
                        .field(entry.getKey())
                        .message(entry.getValue())
                        .build())
                .toList();

        ControllerResultError error = ControllerResultError.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .details(details)
                .build();

        return ControllerResult.<Void>builder()
                .status("error")
                .error(error)
                .build();
    }

    public static ControllerResult<Void> getErrorResultFromRepositoryException(RepositoryException exception) {
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

        return ControllerResult.<Void>builder()
                .status("error")
                .error(error)
                .build();
    }

    public static ControllerResult<Void> getErrorResult(String code, String message, KeyValuePair<String, String> keyValuePair) {
       ControllerResultError error = ControllerResultError.builder()
                .code(code)
                .message(message)
                .details(List.of(ControllerResultErrorDetail.builder()
                        .code(keyValuePair.getKey())
                        .message(keyValuePair.getValue())
                        .build()))
                .build();

        return ControllerResult.<Void>builder()
                .status("error")
                .error(error)
                .build();
    }
}
