package ma.ibi.parent.infra.agent;

import ma.ibi.parent.infra.projet.ProjectEntity;
import ma.ibi.parent.infra.tache.TacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AgentRepository extends JpaRepository<AgentEntity,Integer> {

    Optional<AgentEntity> findByMatricule(Integer matricule);


}
