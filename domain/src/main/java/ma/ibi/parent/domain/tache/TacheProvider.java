package ma.ibi.parent.domain.tache;


import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.project.ProjectAggregate;

import java.util.List;

public interface TacheProvider {
    List<TacheAggregete> getAll();
    void addTache (TacheAggregete tacheAggregete);
    void  deleteAll();
    void  deleteTache(String label);
 
}
