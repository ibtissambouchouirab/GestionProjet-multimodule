package ma.ibi.parent.domain.tache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TacheAggregete {
    private Long id;
    private String nom;
    private String code;
    private String priority;
    private String status;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateFinReel;
    private LocalDateTime dateFinAttendu;
    private LocalDateTime estimation;


}
