package ma.ibi.parent.prez.project;

import lombok.RequiredArgsConstructor;
import ma.ibi.parent.domain.project.ProjectAggregate;
import ma.ibi.parent.domain.project.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static ma.ibi.parent.prez.common.Constants.*;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping(PROJECT_BASE_URL)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping(PROJECT_BASE_URL)
    public ResponseEntity<String> addProject(@RequestBody ProjectAggregate projectAggregate){
        projectService.deleteProject(projectAggregate);
        return new ResponseEntity<>("Project is create ", HttpStatus.CREATED);
    }

    @DeleteMapping(PROJECT_BASE_URL)
    public ResponseEntity<String> delete(){
        projectService.deleteAll();
        return new ResponseEntity<>(" All project is deleted ", HttpStatus.CREATED);
    }

    @DeleteMapping(PROJECT_DELETE_URL)
    public ResponseEntity<String> deleteProject(@PathVariable String code){
        projectService.deleteProject(code);
        return new ResponseEntity<>(" Project is deleted ", HttpStatus.CREATED);
    }
/*
    @GetMapping(AGENTS_PROJECT_URL)
    public ResponseEntity getAgents(@PathVariable String code){
        return ResponseEntity.ok(projectService.getAgents(code));
    }

 */

}
