package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.WorkspaceDto;
import pet.project.calendar.entity.Workspace;
import pet.project.calendar.exception.WorkspaceNotFoundException;
import pet.project.calendar.service.WorkspaceService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    private WorkspaceService workspacesService;

    @Autowired
    public void setWorkspacesService(WorkspaceService workspacesService) {
        this.workspacesService = workspacesService;
    }

    @GetMapping("/findWorkspaceById/{id}")
    public ResponseEntity<Workspace> findWorkspaceById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(workspacesService.findWorkspaceById(id), HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findWorkspacesByName/{name}")
    public ResponseEntity<List<Workspace>> findWorkspacesByName(@PathVariable("name") String name){
        try{
            List<Workspace> workspacesList = workspacesService.findWorkspacesByName(name);
            return new ResponseEntity<>(workspacesList, HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findWorkspacesByUserId/{userId}")
    public ResponseEntity<List<Workspace>> findWorkspacesByUserId(@PathVariable("userId") Integer userId){
        try {
            List<Workspace> workspacesList = workspacesService.findWorkspacesByUserId(userId);
            return new ResponseEntity<>(workspacesList, HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/addWorkspace", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Workspace> addWorkspace(@RequestBody WorkspaceDto workspaceDto){
        try {
            Workspace workspace = workspacesService.addWorkspace(workspaceDto);
            return new ResponseEntity<>(workspace, HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/updateWorkspace/{id}")
    public void updateWorkspaces(@PathVariable Integer id, @PathVariable Map<String, String> json){
        workspacesService.updateWorkspace(id, json.get("name"));
    }

    @DeleteMapping("/deleteWorkspacesById/{id}")
    public ResponseEntity<Workspace> deleteWorkspacesById(@PathVariable("id") Integer id){
        try {
            workspacesService.deleteWorkspacesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Deprecated
    @DeleteMapping("/deleteWorkspacesByName/{name}")
    public ResponseEntity<Workspace> deleteWorkspacesByName(@PathVariable("name") String name){
        try {
            workspacesService.deleteWorkspacesByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (WorkspaceNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
