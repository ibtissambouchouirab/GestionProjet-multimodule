package ma.ibi.parent.infra.projet;

import ma.ibi.parent.infra.agent.AgentEntity;
import ma.ibi.parent.infra.projet.ProjectEntity;
import ma.ibi.parent.infra.tache.TacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    Optional<ProjectEntity> findByCode(String code);

}
