package ma.ibi.parent.infra.tache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.ibi.parent.infra.agent.AgentEntity;
import ma.ibi.parent.infra.projet.ProjectEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "TACHE")
public class TacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    private String priority;
    private String Status;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinReel;
    private LocalDateTime dateFinAttendu;
    private LocalDateTime estimation;

}
