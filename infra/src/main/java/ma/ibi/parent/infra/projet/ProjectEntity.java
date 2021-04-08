package ma.ibi.parent.infra.projet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.ibi.parent.infra.agent.AgentEntity;
import ma.ibi.parent.infra.tache.TacheEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PROJECT")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinReel;
    private LocalDateTime dateFinAttendu;
    @ManyToMany
    public List<AgentEntity> agentEntities;
    @ManyToOne
    public List<TacheEntity> tacheEntities;

}
