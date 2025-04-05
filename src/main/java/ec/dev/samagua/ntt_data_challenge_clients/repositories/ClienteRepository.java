package ec.dev.samagua.ntt_data_challenge_clients.repositories;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import ec.dev.samagua.ntt_data_challenge_clients.jpa_repositories.ClienteJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClienteRepository {

    private final ClienteJpaRepository repository;

    public Optional<Cliente> save(Cliente cliente) {
        return Optional.of(repository.save(cliente));
    }

    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }
}
