package ec.dev.samagua.ntt_data_challenge_clients.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ec.dev.samagua.ntt_data_challenge_clients.config.JsonDateDeserializer;
import ec.dev.samagua.ntt_data_challenge_clients.config.JsonDateSerializer;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@SuperBuilder
public abstract class Persona {
    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "nombre")
    private String nombre;

    @Column(value = "genero")
    private String genero;

    @Column(value = "fecha_nacimiento")
    //@JsonSerialize(using = JsonDateSerializer.class)
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    private LocalDate fechaNacimiento;

    @Column(value= "identificacion")
    private String identificacion;

    @Column(value = "direccion")
    private String direccion;

    @Column(value= "telefono")
    private String telefono;

    public Long getEdad() {
        if (this.fechaNacimiento == null) {
            return null;
        }
        return  ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());
    }
}
