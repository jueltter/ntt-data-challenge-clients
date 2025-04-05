package ec.dev.samagua.ntt_data_challenge_clients.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Persona {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "nombre")
    private String nombre;

    @Column(value = "genero")
    private String genero;

    @Column(value = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(value= "identificacion")
    private String identificacion;

    @Column(value = "direccion")
    private String direccion;

    @Column(value= "telefono")
    private String telefono;
}
