package ma.ibi.parent.prez.tache;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.tache.TacheAggregete;
import ma.ibi.parent.domain.tache.TacheService;
import static ma.ibi.parent.prez.common.Constants.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TacheController {

    private final TacheService tacheService;


    @GetMapping(TASK_BASE_URL)
    public ResponseEntity getAll(){

        return ResponseEntity.ok(tacheService.getAll());
    }

    @DeleteMapping(TASK_BASE_URL)
    public ResponseEntity<String> delete(){
        tacheService.deleteAll();
        return new ResponseEntity<>(" DELETED ALL TACHES ", HttpStatus.CREATED);
    }


    @PostMapping(TASK_BASE_URL)
    public ResponseEntity<String> addTache(@RequestBody TacheAggregete tacheAggregete ){
        tacheService.addTache(tacheAggregete);
        return new ResponseEntity<>("Is CREATED ", HttpStatus.CREATED);
    }

    @DeleteMapping(TASK_DELETE_URL)
    public ResponseEntity<String> delete(@PathVariable String codeT){
        tacheService.deleteTache(codeT);
        return new ResponseEntity<>(" IS DELETED  ", HttpStatus.CREATED);
    }
    @GetMapping(TASK_BASE_URL)
    public ResponseEntity getAgents(){

        return ResponseEntity.ok(tacheService.getAll());
    }


}
