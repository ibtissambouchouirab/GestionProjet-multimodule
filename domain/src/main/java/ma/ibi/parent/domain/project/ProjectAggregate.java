package ma.ibi.parent.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectAggregate {

    private Long id;
    private String nom;
    private String code;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinReel;
    private LocalDateTime dateFinAttendu;
    List<TacheAggregete> tacheAggregetes;
    List<AgentAggregate> AgentAggregetes;

}
