package ma.ibi.parent.infra.projet;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.exceptionhandler.ProjectNotFound;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.project.ProjectProvider;
import ma.ibi.parent.domain.tache.TacheAggregete;
import ma.ibi.parent.infra.agent.AgentAdapter;
import ma.ibi.parent.infra.tache.TacheAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectProviderImpl implements ProjectProvider {

    private final ProjectRepository projectRepository;
    private final ProjectAdapter projectAdapter;
    private final AgentAdapter agentAdapter;
    private final TacheAdapter tacheAdapter;

    @Override
    public List<ProjectAggregate> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectEntity -> new ProjectAggregate(projectEntity.getId(),
                        projectEntity.getNom(),
                        projectEntity.getCode(),
                        projectEntity.getDescription(),
                        projectEntity.getDateCreation(),
                        projectEntity.getDateFinReel(),
                        projectEntity.getDateFinAttendu(),
                        tacheAdapter.adaptertoAggregates(projectEntity.getTacheEntities()),
                        agentAdapter.adaptertoAggregates(projectEntity.getAgentEntities())))
                .collect(Collectors.toList());
    }

    @Override
    public void addProject(ProjectAggregate projectAggregate) {
        projectRepository.save(projectAdapter.adapter(projectAggregate));
    }

    @Override
    public void deleteAll() {
        projectRepository.deleteAll();
    }

    @Override
    public void deleteProject(String code) throws ProjectNotFound {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findByCode(code);
        if(optionalProjectEntity.isPresent()){
            projectRepository.delete(optionalProjectEntity.get());
        }
        else {
            throw new ProjectNotFound();
        }

    }

    @Override
    public List<TacheAggregete> getATaches(String code) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findByCode(code);
        if(optionalProjectEntity.isPresent()){
            return tacheAdapter.adaptertoAggregates(optionalProjectEntity.get().getTacheEntities());
        }
        else {
            throw new ProjectNotFound();
        }
    }

    @Override
    public List<AgentAggregate> getAgents(String code) {

        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findByCode(code);
        if(optionalProjectEntity.isPresent()){
            return agentAdapter.adaptertoAggregates(optionalProjectEntity.get().getAgentEntities());
        }
        else {
            throw new ProjectNotFound();
        }
    }
}
