package ec.dev.samagua.ntt_data_challenge_clients.utils_exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepositoryExceptionDetail {
    private String code;
    private String message;
}
