package ec.dev.samagua.ntt_data_challenge_clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {
    private Long id;
    private String nombre;
    private String genero;
    private Date fechaNacimiento;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String clienteId;
    private String clave;
    private String estado;
}
