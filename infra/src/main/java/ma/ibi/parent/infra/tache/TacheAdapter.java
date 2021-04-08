package ma.ibi.parent.infra.tache;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;
import ma.ibi.parent.infra.agent.AgentAdapter;
import ma.ibi.parent.infra.projet.ProjectAdapter;
import ma.ibi.parent.infra.projet.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TacheAdapter {

    public TacheAggregete adapter (TacheEntity tacheEntity){
        return new TacheAggregete(
                tacheEntity.getId(),
                tacheEntity.getNom(),
                tacheEntity.getCode(),
                tacheEntity.getPriority(),
                tacheEntity.getStatus(),
                tacheEntity.getDescription(),
                tacheEntity.getDateCreation(),
                tacheEntity.getDateFinReel(),
                tacheEntity.getDateFinAttendu(),
                tacheEntity.getEstimation());
    }
    public TacheEntity adapter (TacheAggregete tacheAggregete ){
        return new TacheEntity(
                tacheAggregete.getId(),
                tacheAggregete.getNom(),
                tacheAggregete.getCode(),
                tacheAggregete.getPriority(),
                tacheAggregete.getStatus(),
                tacheAggregete.getDescription(),
                tacheAggregete.getDateCreation(),
                tacheAggregete.getDateFinReel(),
                tacheAggregete.getDateFinAttendu(),
                tacheAggregete.getEstimation());
    }
    public List<TacheAggregete> adaptertoAggregates(List<TacheEntity> tacheEntities){
        return tacheEntities.stream().map(this::adapter).collect(Collectors.toList());
    }
    public List<TacheEntity> adaptertoEntities(List<TacheAggregete> tacheAggregetes){
        return tacheAggregetes.stream().map(this::adapter).collect(Collectors.toList());
    }
}
