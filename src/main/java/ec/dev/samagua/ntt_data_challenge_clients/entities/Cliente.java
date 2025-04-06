package ec.dev.samagua.ntt_data_challenge_clients.entities;

import ec.dev.samagua.ntt_data_challenge_clients.utils_data.DataValidationResult;
import ec.dev.samagua.ntt_data_challenge_clients.utils_data.IdentityFieldWrapper;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Persona {
    private static final List<String> GENEROS = List.of("MALE", "FEMALE", "PREFER NOT TO SAY");
    private static final List<String> ESTADOS = List.of("TRUE", "FALSE");

    @Column(value= "clienteId")
    private String clienteId;

    @Column(value= "clave")
    private String clave;

    @Column(value= "estado")
    private String estado;

    public static Cliente getDefaultInstance() {
        return Cliente.builder()
                .id(-1L)
                .build();
    }

    public boolean isValidId() {
        return getId() != null && getId() > 0;
    }

    public DataValidationResult validateForCreating(Long countIdentificacion, Long countClienteId) {
        Map<String, String> errors = new HashMap<>();

        // validate id
        if (this.getId() != null) {
            errors.put("id", "must be null");
        }

        // validate client name
        if (this.getNombre() == null || this.getNombre().isBlank()) {
            errors.put("nombre", "is mandatory");
        }

        // validate client gender
        if (this.getGenero() != null) {
            if (!GENEROS.contains(this.getGenero())) {
                errors.put("genero", "possible values are: " + GENEROS);
            }
        }

        // validate client birthdate
        if (this.getFechaNacimiento() != null) {
            if (this.getFechaNacimiento().isAfter(LocalDate.now())) {
                errors.put("fechaNacimiento", "is mandatory and must be a past date");
            }
        }

        // validate client identification
        if (countIdentificacion > 0) {
            errors.put("identificacion", "is already in use");
        }
        else {
            if (this.getIdentificacion() == null || this.getIdentificacion().isBlank()) {
                errors.put("identificacion", "is mandatory");
            }
        }

        // validate address
        if (this.getDireccion() == null || this.getDireccion().isBlank()) {
            errors.put("direccion", "is mandatory");
        }

        // validate phone
        if (this.getTelefono() == null || this.getTelefono().isBlank()) {
            errors.put("telefono", "is mandatory");
        }

        // validate client ID
        if (countClienteId > 0) {
            errors.put("clienteId", "is already in use");
        }
        else {
            if (this.getClienteId() == null || this.getClienteId().isBlank()) {
                errors.put("clienteId", "is mandatory");
            }
        }

        // validate password
        if (this.getClave() == null || this.getClave().isBlank()) {
            errors.put("clave", "is mandatory");
        }

        // validate client status
        if (this.getEstado() == null || !ESTADOS.contains(this.getEstado())) {
            errors.put("estado", "possible values are: " + ESTADOS);
        }

        if (!errors.isEmpty()) {
            return DataValidationResult.builder()
                    .valid(Boolean.FALSE)
                    .errors(errors)
                    .build();

        }

        return DataValidationResult.builder()
                .valid(Boolean.TRUE)
                .errors(null)
                .build();
    }

    public DataValidationResult validateForUpdating(IdentityFieldWrapper identificacionWrapper, IdentityFieldWrapper clienteIdWrapper) {
        Map<String, String> errors = new HashMap<>();

        // validate client name
        if (this.getNombre() == null || this.getNombre().isBlank()) {
            errors.put("nombre", "is mandatory");
        }

        // validate client gender
        if (this.getGenero() != null) {
            if (!GENEROS.contains(this.getGenero())) {
                errors.put("genero", "possible values are: " + GENEROS);
            }
        }

        // validate client birthdate
        if (this.getFechaNacimiento() != null) {
            if (this.getFechaNacimiento().isAfter(LocalDate.now())) {
                errors.put("fechaNacimiento", "is mandatory and must be a past date");
            }
        }

        // validate client identification
        if (!identificacionWrapper.noChange() && identificacionWrapper.countIdentificacion() > 0) {
            errors.put("identificacion", "is already in use");
        }

        // validate address
        if (this.getDireccion() == null || this.getDireccion().isBlank()) {
            errors.put("direccion", "is mandatory");
        }

        // validate phone
        if (this.getTelefono() == null || this.getTelefono().isBlank()) {
            errors.put("telefono", "is mandatory");
        }

        // validate client ID
        if (!clienteIdWrapper.noChange() && clienteIdWrapper.countIdentificacion() > 0) {
            errors.put("clienteId", "is already in use");
        }

        // validate password
        if (this.getClave() == null || this.getClave().isBlank()) {
            errors.put("clave", "is mandatory");
        }

        // validate client status
        if (this.getEstado() == null || !ESTADOS.contains(this.getEstado())) {
            errors.put("estado", "possible values are: " + ESTADOS);
        }

        if (!errors.isEmpty()) {
            return DataValidationResult.builder()
                    .valid(Boolean.FALSE)
                    .errors(errors)
                    .build();

        }

        return DataValidationResult.builder()
                .valid(Boolean.TRUE)
                .errors(null)
                .build();
    }
}
