package ma.ibi.parent.domain.project;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectProvider projectProvider;

    public List<ProjectAggregate> getAll() {
        return projectProvider.getAll();
    }

    public void deleteProject(ProjectAggregate projectAggregate) {
        projectProvider.addProject(projectAggregate);
    }

    public void deleteAll() {
        projectProvider.deleteAll();
    }

    public void deleteProject(String code) {
        projectProvider.deleteProject(code);
    }

    public List<AgentAggregate> getAgents(String code) {
        return projectProvider.getAgents(code);
    }

    public Integer inProgressPercentageByCode(String code) {
        List<TacheAggregete> tasks = projectProvider.getTaches(code);
        Long tasksByStatus = tasks.stream().filter(tacheAggregete -> "Encours".equals(tacheAggregete.getStatus())).count();

        Long allTasks = Long.valueOf(projectProvider.getTaches(code).size());

        return Math.toIntExact(tasksByStatus / allTasks);
    }
}
