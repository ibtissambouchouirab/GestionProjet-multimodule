package ma.ibi.parent.infra.agent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.ibi.parent.infra.projet.ProjectEntity;
import ma.ibi.parent.infra.tache.TacheEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "AGENT")
public class AgentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany
    List<ProjectEntity>  projectEntities;
    @ManyToOne
    List<TacheEntity> tacheEntities;


}
