package ma.ibi.parent.domain.agent;

import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;

import java.util.List;
import java.util.Set;

public interface AgentProvider {
    List<AgentAggregate> getAll();
    void saveAgent (AgentAggregate agentAggregate);
    void deleteAgent(Integer matricule);
    void deleteAll();
    List<TacheAggregete> getTaches(Integer matricule);
    List<ProjectAggregate> getProjects(Integer matricule);

}
