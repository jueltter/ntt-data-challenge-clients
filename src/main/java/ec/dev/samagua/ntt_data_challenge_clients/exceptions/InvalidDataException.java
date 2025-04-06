package ec.dev.samagua.ntt_data_challenge_clients.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class InvalidDataException extends RuntimeException {

    private String code;
    private Map<String, String> errors;

    public InvalidDataException(String message) {
        super(message);
    }

    public static InvalidDataException getInstance(Map<String, String> errors) {
        InvalidDataException ex = new InvalidDataException("An error has occurred while validating the object");
        ex.setCode("INVALID_DATA");
        ex.setErrors(errors);
        return ex;
    }

}
