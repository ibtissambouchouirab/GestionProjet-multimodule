package ma.ibi.parent.domain.agent;

import lombok.*;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.tache.TacheAggregete;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgentAggregate {
    private Integer id;
    private Integer matricule;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String profile;
    private Date dateRecrutement;
    private Date dateNaissance;
    private String diplome;
    List<ProjectAggregate> projectAggregates;
    List<TacheAggregete> tacheAggregetes;

}
