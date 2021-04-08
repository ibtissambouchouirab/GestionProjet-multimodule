package ma.ibi.parent.infra.projet;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.infra.agent.AgentAdapter;
import ma.ibi.parent.infra.agent.AgentEntity;
import ma.ibi.parent.infra.tache.TacheAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectAdapter {

    private final AgentAdapter agentAdapter;
    private final TacheAdapter tacheAdapter;

    public ProjectEntity adapter (ProjectAggregate projectAggregate){
       return  new ProjectEntity(projectAggregate.getId(),
                      projectAggregate.getNom(),
                      projectAggregate.getCode(),
                      projectAggregate.getDescription(),
                      projectAggregate.getDateCreation(),
                      projectAggregate.getDateFinReel(),
                      projectAggregate.getDateFinAttendu(),
               agentAdapter.adaptertoEntities(projectAggregate.getAgentAggregetes()),
               tacheAdapter.adaptertoEntities(projectAggregate.getTacheAggregetes()));
    }

    public ProjectAggregate  adapter (ProjectEntity projectEntity){
        return  new ProjectAggregate(projectEntity.getId(),
                projectEntity.getNom(),
                projectEntity.getCode(),
                projectEntity.getDescription(),
                projectEntity.getDateCreation(),
                projectEntity.getDateFinReel(),
                projectEntity.getDateFinAttendu(),
                tacheAdapter.adaptertoAggregates(projectEntity.getTacheEntities()),
                agentAdapter.adaptertoAggregates(projectEntity.getAgentEntities()));
    }
    public List<ProjectAggregate> adaptertoAggregates(List<ProjectEntity> projetEntities){
        return projetEntities.stream().map(this::adapter).collect(Collectors.toList());
    }
    public List<ProjectEntity> adaptertoEntities(List<ProjectAggregate> projectAggregates){
        return projectAggregates.stream().map(this::adapter).collect(Collectors.toList());
    }
}
