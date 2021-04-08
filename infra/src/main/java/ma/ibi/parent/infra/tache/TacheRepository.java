package ma.ibi.parent.infra.tache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TacheRepository extends JpaRepository<TacheEntity, Long> {

    Optional<TacheEntity> findByCode(String code);
}
