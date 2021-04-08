package ma.ibi.parent.domain.project;

import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;

import java.util.List;

public interface ProjectProvider {
    List<ProjectAggregate> getAll();
    void  addProject(ProjectAggregate projectAggregate);
    void  deleteAll();
    void  deleteProject(String code);
    List<TacheAggregete> getTaches(String code);
    List<AgentAggregate> getAgents(String code);


}
