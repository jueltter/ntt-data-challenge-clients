package ec.dev.samagua.ntt_data_challenge_clients.entities;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends Persona {
    @Column(value= "clienteId")
    private String clienteId;

    @Column(value= "clave")
    private String clave;

    @Column(value= "estado")
    private String estado;
}
