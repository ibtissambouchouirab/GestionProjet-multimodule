package ma.ibi.parent.prez.agent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.ibi.parent.domain.agent.AgentAggregate;
import ma.ibi.parent.domain.agent.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static ma.ibi.parent.prez.common.Constants.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AgentController {
    private final AgentService agentService;

    @GetMapping(AGENT_BASE_URL)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(agentService.getAll());
    }

    @PostMapping(TASK_BASE_URL)
    public ResponseEntity<String> AddAgent(@RequestBody AgentAggregate agentAggregate){
        agentService.addAgent(agentAggregate);
        return new ResponseEntity<>("Is CREATED ", HttpStatus.CREATED);
    }

    @DeleteMapping(AGENT_DELETE_URL)
    public ResponseEntity<String> deleteAgent(@PathVariable Integer matricule ){
        agentService.deleteAgent(matricule);
           return new ResponseEntity<>("Is Deleted", HttpStatus.CREATED);
    }

    @DeleteMapping(AGENT_BASE_URL)
    public ResponseEntity<String> deleteAllAgent(){
       agentService.deleteAll();
       return  new ResponseEntity<>("Delete ALL AGENT", HttpStatus.CREATED);
    }
    /*

    @GetMapping(PROJECTS_AGENT_URL)
    public ResponseEntity getProjects(@PathVariable Integer matricule){
        return ResponseEntity.ok(agentService.getProjects(matricule));
    }
    @GetMapping(TACHES_AGENT_URL)
    public ResponseEntity getTaches(@PathVariable Integer matricule){
        return ResponseEntity.ok(agentService.getTaches(matricule));
    }

     */

}
