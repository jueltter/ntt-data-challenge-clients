package ec.dev.samagua.ntt_data_challenge_clients.dtos_mappers;

import ec.dev.samagua.ntt_data_challenge_clients.dtos.ClienteDto;
import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    //@Mapping(source = "fechaNacimiento", target = "fechaNacimiento", dateFormat = "dd/MM/yyyy")
    ClienteDto entityToDto(Cliente cliente);

    //@Mapping(source = "fechaNacimiento", target = "fechaNacimiento", dateFormat = "dd/MM/yyyy")
    Cliente dtoToEntity(ClienteDto clienteDto);

    @Mapping(ignore = true, target = "clave")
    ClienteDto entityToDtoObfuscated(Cliente cliente);
}
