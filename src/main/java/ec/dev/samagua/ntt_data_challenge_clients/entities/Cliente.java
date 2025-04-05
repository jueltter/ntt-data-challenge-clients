package ec.dev.samagua.ntt_data_challenge_clients.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends Persona {
    @Column(name= "clienteId")
    private String clienteId;

    @Column(name= "clave")
    private String clave;

    @Column(name= "estado")
    private String estado;
}
