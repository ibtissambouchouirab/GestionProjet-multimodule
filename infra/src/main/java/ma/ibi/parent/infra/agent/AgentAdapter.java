package ma.ibi.parent.infra.agent;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.infra.projet.ProjectAdapter;
import ma.ibi.parent.infra.tache.TacheAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgentAdapter {

    private final ProjectAdapter projectAdapter;
    private final TacheAdapter tacheAdapter;


    public AgentEntity adapter (AgentAggregate agentAggregate){
        return new AgentEntity(agentAggregate.getId() ,
                agentAggregate.getMatricule(),
                agentAggregate.getNom(),
                agentAggregate.getPrenom(),
                agentAggregate.getEmail(),
                agentAggregate.getPassword(),
                agentAggregate.getProfile(),
                agentAggregate.getDateRecrutement(),
                agentAggregate.getDateNaissance(),
                agentAggregate.getDiplome(),
                projectAdapter.adaptertoEntities(agentAggregate.getProjectAggregates()),
                tacheAdapter.adaptertoEntities(agentAggregate.getTacheAggregetes()));
    }

    public AgentAggregate adapter (AgentEntity agentEntity){
        return new AgentAggregate(agentEntity.getId() ,
                agentEntity.getMatricule(),
                agentEntity.getNom(),
                agentEntity.getPrenom(),
                agentEntity.getEmail(),
                agentEntity.getPassword(),
                agentEntity.getProfile(),
                agentEntity.getDateRecrutement(),
                agentEntity.getDateNaissance(),
                agentEntity.getDiplome(),
                projectAdapter.adaptertoAggregates(agentEntity.getProjectEntities()),
                tacheAdapter.adaptertoAggregates(agentEntity.getTacheEntities()));
    }

    public List<AgentAggregate> adaptertoAggregates(List<AgentEntity> agetEntities){
        return agetEntities.stream().map(this::adapter).collect(Collectors.toList());
    }

    public List<AgentEntity> adaptertoEntities(List<AgentAggregate> agentAggregate){
        return agentAggregate.stream().map(this::adapter).collect(Collectors.toList());
    }
}
