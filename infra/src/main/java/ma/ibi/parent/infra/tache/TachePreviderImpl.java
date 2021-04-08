package ma.ibi.parent.infra.tache;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.exceptionhandler.TacheNotFound;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;
import ma.ibi.parent.domain.tache.TacheProvider;
import ma.ibi.parent.infra.agent.AgentAdapter;
import ma.ibi.parent.infra.projet.ProjectAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TachePreviderImpl implements TacheProvider {


   private final TacheRepository tacheRepository;
   private final TacheAdapter tacheAdapter;

    @Override
    public List<TacheAggregete> getAll() {
        return tacheRepository.findAll()
                .stream()
                .map(tacheEntity -> new TacheAggregete(
                        tacheEntity.getId(),
                        tacheEntity.getNom(),
                        tacheEntity.getCode(),
                        tacheEntity.getPriority(),
                        tacheEntity.getStatus(),
                        tacheEntity.getDescription(),
                        tacheEntity.getDateCreation(),
                        tacheEntity.getDateFinReel(),
                        tacheEntity.getDateFinAttendu(),
                        tacheEntity.getEstimation()))
                .collect(Collectors.toList());
    }

    @Override
    public void addTache(TacheAggregete tacheAggregete) {

        tacheRepository.save(tacheAdapter.adapter(tacheAggregete));
    }

    @Override
    public void deleteAll() {
        tacheRepository.deleteAll();
    }

    @Override
    public void deleteTache(String code) throws TacheNotFound {
        Optional<TacheEntity> optionalTacheEntity = tacheRepository.findByCode(code);
        if(optionalTacheEntity.isPresent()){
            tacheRepository.delete(optionalTacheEntity.get());
        }
        else {
            throw new TacheNotFound();
        }

    }
}
