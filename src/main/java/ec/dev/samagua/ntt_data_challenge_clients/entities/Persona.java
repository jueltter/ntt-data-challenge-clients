package ec.dev.samagua.ntt_data_challenge_clients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "genero")
    private String genero;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name= "identificacion")
    private String identificacion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name= "telefono")
    private String telefono;
}
