package ec.dev.samagua.ntt_data_challenge_clients.utils_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeyValuePair<E, T> {
    private E key;
    private T value;
}
