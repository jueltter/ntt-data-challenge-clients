package ec.dev.samagua.ntt_data_challenge_clients.services_utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResult<E> {
    private E value;
    private List<String> errors;
}
