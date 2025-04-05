package ec.dev.samagua.ntt_data_challenge_clients.dtos_mappers;

import ec.dev.samagua.ntt_data_challenge_clients.dtos.ClienteDto;
import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    ClienteDto entityToDto(Cliente cliente);

    ClienteDto dtoToEntity(ClienteDto clienteDto);

    @Mapping(ignore = true, target = "clave")
    ClienteDto entityToDtoObfuscated(Cliente cliente);
}
