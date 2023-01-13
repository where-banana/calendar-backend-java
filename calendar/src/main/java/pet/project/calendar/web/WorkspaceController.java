package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.WorkspaceDto;
import pet.project.calendar.entity.Event;
import pet.project.calendar.entity.Workspace;
import pet.project.calendar.exception.WorkspaceNotFoundException;
import pet.project.calendar.service.WorkspaceService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/entity-management")
public class WorkspaceController {

    private WorkspaceService workspacesService;

    @Autowired
    public void setWorkspacesService(WorkspaceService workspacesService) {
        this.workspacesService = workspacesService;
    }

    @GetMapping("/workspaces/{id}")
    public ResponseEntity<WorkspaceDto> findWorkspaceById(@PathVariable("id") Integer id){
        try{
            Workspace ws = workspacesService.findWorkspaceById(id);
            String name = ws.getName();
            Collection<Event> events = ws.getEvents();
            WorkspaceDto workspaceDto = new WorkspaceDto(name, events);
            return new ResponseEntity<>(workspaceDto, HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/workspaces")
    public ResponseEntity<List<Workspace>> findAllWorkspaces(){
        try {
            return new ResponseEntity<>(workspacesService.findAll(), HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/workspaces",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Workspace> add(@RequestBody WorkspaceDto workspaceDto){
        try {
            Workspace workspace = workspacesService.add(workspaceDto);
            return new ResponseEntity<>(workspace, HttpStatus.CREATED);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/workspaces/{id}")
    public void updateWorkspaces(@PathVariable Integer id, @RequestBody Map<String, Object> json){
        workspacesService.updateWorkspace(id, (String) json.get("name"));
    }

    @DeleteMapping("/workspaces/{id}")
    public ResponseEntity<Workspace> deleteWorkspacesById(@PathVariable("id") Integer id){
        try {
            workspacesService.deleteWorkspacesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
