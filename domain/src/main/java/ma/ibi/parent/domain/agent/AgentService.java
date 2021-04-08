package ma.ibi.parent.domain.agent;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentProvider agentProvider;

    public List<AgentAggregate> getAll(){
        return agentProvider.getAll();
    }

    public void addAgent(AgentAggregate agentAggregate){
        agentProvider.saveAgent(agentAggregate);
    }

    public void deleteAll(){
        agentProvider.deleteAll();
    }

    public void deleteAgent(Integer matricule) { agentProvider.deleteAgent(matricule); }

    public List<ProjectAggregate> getProjects(Integer matricule){
        return agentProvider.getProjects(matricule);
    }

    public List<TacheAggregete> getTaches(Integer matricule){ return agentProvider.getTaches(matricule);
    }

}
