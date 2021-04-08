package ma.ibi.parent.infra.agent;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.agent.AgentProvider;
import ma.ibi.parent.domain.exceptionhandler.AgentNotFound;
import ma.ibi.parent.domain.exceptionhandler.ProjectNotFound;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;
import ma.ibi.parent.infra.projet.ProjectAdapter;
import ma.ibi.parent.infra.projet.ProjectEntity;
import ma.ibi.parent.infra.tache.TacheAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgentProviderImpl implements AgentProvider {

    private final AgentRepository agentRepository;
    private final AgentAdapter agentAdapter;
    private final ProjectAdapter projectAdapter;
    private final TacheAdapter tacheAdapter;

    @Override
    public List<AgentAggregate> getAll() {
        return agentRepository.findAll()
                .stream()
                .map(agentEntity -> new AgentAggregate(
                        agentEntity.getId(),
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
                        tacheAdapter.adaptertoAggregates(agentEntity.getTacheEntities())
                        )
                ).collect(Collectors.toList());
    }

    @Override
    public void saveAgent(AgentAggregate agentAggregate) {
        agentRepository.save(agentAdapter.adapter(agentAggregate));
    }

    @Override
    public void deleteAgent(Integer matricule) throws AgentNotFound {

        Optional<AgentEntity> optionalAgentEntity = agentRepository.findByMatricule(matricule);

        if (optionalAgentEntity.isPresent()) {
            agentRepository.delete(optionalAgentEntity.get());

        }else {
            throw new AgentNotFound();
        }
    }

    @Override
    public void deleteAll() {
        agentRepository.deleteAll();
    }

    @Override
    public List<TacheAggregete> getTaches(Integer matricule) {
        Optional<AgentEntity> optionalAgentEntity = agentRepository.findByMatricule(matricule);
        if(optionalAgentEntity.isPresent()){
            return tacheAdapter.adaptertoAggregates(optionalAgentEntity.get().getTacheEntities());
        }
        else {
            throw new ProjectNotFound();
        }
    }

    @Override
    public List<ProjectAggregate> getProjects(Integer matricule) {
        Optional<AgentEntity> optionalAgentEntity = agentRepository.findByMatricule(matricule);
        if(optionalAgentEntity.isPresent()){
            return projectAdapter.adaptertoAggregates(optionalAgentEntity.get().getProjectEntities());
        }
        else {
            throw new ProjectNotFound();
        }
    }
}
