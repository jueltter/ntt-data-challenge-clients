package ec.dev.samagua.ntt_data_challenge_clients.jpa_repositories;

import ec.dev.samagua.ntt_data_challenge_clients.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>  {
}
